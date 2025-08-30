package com.patrick.hotel_service.controller;

import com.patrick.hotel_service.dto.HotelRequest;
import com.patrick.hotel_service.dto.HotelResponse;
import com.patrick.hotel_service.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<HotelResponse> createHotel(@RequestBody @Valid HotelRequest hotelRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotelRequest));
    }

    @GetMapping("/{id}")
        public ResponseEntity<HotelResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(hotelService.findHotelById(id));
    }
}
