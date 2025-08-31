package com.patrick.hotel_service.controller;

import com.patrick.hotel_service.dto.HotelRequest;
import com.patrick.hotel_service.dto.HotelResponse;
import com.patrick.hotel_service.dto.UpdateStatusHotelRequest;
import com.patrick.hotel_service.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public ResponseEntity<Page<HotelResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok(hotelService.findAllHotels(pageable));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable UUID id, @RequestBody UpdateStatusHotelRequest statusRequest) {
        hotelService.updateStatus(id, statusRequest);
        return ResponseEntity.noContent().build();
    }
}
