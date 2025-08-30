package com.patrick.booking_service.service;

import com.patrick.booking_service.client.HotelClient;
import com.patrick.booking_service.dto.BookingRequest;
import com.patrick.booking_service.dto.BookingResponse;
import com.patrick.booking_service.dto.hotel.HotelResponseClient;
import com.patrick.booking_service.mapper.BookingMapper;
import com.patrick.booking_service.repository.BookingRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.apache.coyote.ActionCode.AVAILABLE;

@Service
@Log4j2
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final HotelClient hotelClient;

    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper, HotelClient hotelClient) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.hotelClient = hotelClient;
    }

    public BookingResponse makeBooking(UUID userId, BookingRequest request) {
        HotelResponseClient hotel = hotelClient.findHotel(request.hotelId());
        log.info(hotel);

        if (!hotel.status().equals("AVAILABLE")) {
            throw new RuntimeException("Hotel busy or inactive");
        }

        if (request.guestCount() > hotel.capacity()) throw new RuntimeException(String.format(
                "The hotel capacity has been exceeded. This hotel only allows '%s' people per room.", hotel.capacity()));

        return null;
    }

}
