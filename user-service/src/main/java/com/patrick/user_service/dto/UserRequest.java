package com.patrick.user_service.dto;

import com.patrick.user_service.model.User;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(@NotBlank String name, @NotBlank String email) {

    public static User toUser(UserRequest request) {
        return new User(null, request.name(), request.email());
    }
}
