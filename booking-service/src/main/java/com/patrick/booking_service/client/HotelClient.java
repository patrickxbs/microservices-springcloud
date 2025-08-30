package com.patrick.booking_service.client;

import com.patrick.booking_service.dto.hotel.HotelResponseClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "HOTEL-SERVICE")
public interface HotelClient {

    @GetMapping("/hotels/{hotelId}")
    HotelResponseClient findHotel(@PathVariable UUID hotelId);
}
