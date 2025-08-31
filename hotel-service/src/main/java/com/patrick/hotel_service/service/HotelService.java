package com.patrick.hotel_service.service;

import com.patrick.hotel_service.dto.HotelRequest;
import com.patrick.hotel_service.dto.HotelResponse;
import com.patrick.hotel_service.dto.UpdateStatusHotelRequest;
import com.patrick.hotel_service.mapper.HotelMapper;
import com.patrick.hotel_service.model.Hotel;
import com.patrick.hotel_service.repository.HotelRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    public HotelResponse createHotel(HotelRequest request) {
        Hotel hotel = hotelMapper.toHotel(request);
        hotel.setId(UUID.randomUUID());
        return hotelMapper.toResponse(hotelRepository.save(hotel));
    }

    public HotelResponse findHotelById(UUID id) {
        return hotelMapper.toResponse(findHotelByIdOrExceptionNotFound(id));
    }

    public Page<HotelResponse> findAllHotels(Pageable pageable) {
        Page<Hotel> hotels = hotelRepository.findAll(pageable);
        return hotels.map(hotelMapper::toResponse);
    }

    public void updateStatus(UUID id, UpdateStatusHotelRequest statusRequest) {
        Hotel hotel = findHotelByIdOrExceptionNotFound(id);
        hotel.setStatus(statusRequest.status());
        hotelRepository.save(hotel);
    }

    private Hotel findHotelByIdOrExceptionNotFound(UUID id) {
        return hotelRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Hotel with id '%s' not found", id)));
    }
}
