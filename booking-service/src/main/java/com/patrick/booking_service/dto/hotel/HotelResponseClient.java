package com.patrick.booking_service.dto.hotel;

import java.util.UUID;

public record HotelResponseClient(UUID id, String code, Integer capacity, String status, Double unitPrice) {
}
