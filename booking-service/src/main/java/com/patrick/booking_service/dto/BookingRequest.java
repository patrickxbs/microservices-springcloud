package com.patrick.booking_service.dto;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.UUID;

public record BookingRequest(@NonNull UUID hotelId, @NonNull LocalDate checkInDate, @NonNull LocalDate checkOutDate,
                             @NonNull Integer guestCount) {
}
