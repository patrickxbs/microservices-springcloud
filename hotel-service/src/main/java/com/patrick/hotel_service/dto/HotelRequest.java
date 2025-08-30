package com.patrick.hotel_service.dto;

import com.patrick.hotel_service.model.enuns.StatusHotel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HotelRequest(@NotBlank String code, @NotNull Integer capacity, @NotNull StatusHotel status,
                           @NotNull Double unitPrice) {
}
