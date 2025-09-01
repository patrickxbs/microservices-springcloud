package com.patrick.booking_service.controller;

import com.patrick.booking_service.dto.BookingRequest;
import com.patrick.booking_service.dto.BookingResponse;
import com.patrick.booking_service.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<BookingResponse> createBooking(@PathVariable UUID userId, @RequestBody @Valid BookingRequest bookingRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.makeBooking(userId, bookingRequest));
    }
}
