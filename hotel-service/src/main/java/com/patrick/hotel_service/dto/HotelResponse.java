package com.patrick.hotel_service.dto;

import com.patrick.hotel_service.model.enuns.StatusHotel;

import java.util.UUID;

public record HotelResponse(UUID id, String code, Integer capacity, StatusHotel status, Double unitPrice) {
}
