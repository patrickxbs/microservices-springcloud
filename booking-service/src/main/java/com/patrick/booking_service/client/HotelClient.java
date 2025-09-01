package com.patrick.booking_service.client;

import com.patrick.booking_service.dto.hotel.HotelResponseClient;
import com.patrick.booking_service.dto.hotel.UpdateStatusHotelRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(value = "HOTEL-SERVICE")
public interface HotelClient {

    @GetMapping("/hotels/{hotelId}")
    HotelResponseClient findHotelById(@PathVariable UUID hotelId);

    @PutMapping("/hotels/{hotelId}")
    void updateHotel(@PathVariable UUID hotelId, @RequestBody UpdateStatusHotelRequest status);
}
