package com.patrick.booking_service.dto;

import com.patrick.booking_service.model.enuns.BookingStatus;

import java.time.LocalDate;
import java.util.UUID;

public record BookingResponse(UUID id, UUID userId, UUID hotelId, LocalDate checkInDate, LocalDate checkOutDate, Double totalPrice,
                              Integer guestCount, BookingStatus status) {
}
