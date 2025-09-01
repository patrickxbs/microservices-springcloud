package com.patrick.booking_service.service;

import com.patrick.booking_service.client.HotelClient;
import com.patrick.booking_service.client.UserClient;
import com.patrick.booking_service.dto.BookingRequest;
import com.patrick.booking_service.dto.BookingResponse;
import com.patrick.booking_service.dto.hotel.HotelResponseClient;
import com.patrick.booking_service.dto.hotel.StatusHotel;
import com.patrick.booking_service.dto.hotel.UpdateStatusHotelRequest;
import com.patrick.booking_service.dto.user.UserResponseClient;
import com.patrick.booking_service.mapper.BookingMapper;
import com.patrick.booking_service.model.Booking;
import com.patrick.booking_service.model.enuns.BookingStatus;
import com.patrick.booking_service.repository.BookingRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@Log4j2
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final HotelClient hotelClient;
    private final UserClient userClient;

    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper, HotelClient hotelClient, UserClient userClient) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.hotelClient = hotelClient;
        this.userClient = userClient;
    }

    public BookingResponse makeBooking(UUID userId, BookingRequest request) {

        if (!validateDate(request.checkInDate(), request.checkOutDate())) throw new RuntimeException("Invalid Date");

        HotelResponseClient hotel = hotelClient.findHotelById(request.hotelId());
        log.info(hotel);

        if (!hotel.status().equals("AVAILABLE")) throw new RuntimeException("Hotel busy or inactive");

        if (request.guestCount() > hotel.capacity()) throw new RuntimeException(String.format(
                "The hotel capacity has been exceeded. This hotel only allows '%s' people per room.", hotel.capacity()));

        UserResponseClient user = userClient.findUserById(userId);
        log.info(user);
        if (user == null) throw new RuntimeException("User not found");

        Booking booking = bookingMapper.toBooking(request);
        booking.setUserId(userId);

        long days = ChronoUnit.DAYS.between(request.checkInDate(), request.checkOutDate());
        double totalPrice = days * hotel.unitPrice();

        booking.setTotalPrice(totalPrice);
        booking.setStatus(BookingStatus.PENDING);
        log.info(booking);

        hotelClient.updateHotel(request.hotelId(), new UpdateStatusHotelRequest(StatusHotel.BOOKED));

        return bookingMapper.toResponse(bookingRepository.save(booking));
    }

    private boolean validateDate(LocalDate checkIn, LocalDate checkOut) {
        if (checkIn.isBefore(LocalDate.now())) return false;

        if (checkOut.isAfter(checkIn)) return true;

        return false;
    }


}
