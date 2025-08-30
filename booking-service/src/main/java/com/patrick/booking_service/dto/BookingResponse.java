package com.patrick.booking_service.dto;

import java.time.LocalDate;
import java.util.UUID;

public record BookingResponse(UUID userId, UUID hotelId, LocalDate checkInDate, LocalDate checkOutDate, Integer guestCount) {
}
