package com.patrick.hotel_service.service;

import com.patrick.hotel_service.dto.HotelRequest;
import com.patrick.hotel_service.dto.HotelResponse;
import com.patrick.hotel_service.mapper.HotelMapper;
import com.patrick.hotel_service.model.Hotel;
import com.patrick.hotel_service.repository.HotelRepository;
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
        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Hotel with id '%s' not found", id)));
        return hotelMapper.toResponse(hotel);
    }
}
