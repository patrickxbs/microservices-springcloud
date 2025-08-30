package com.patrick.booking_service.dto.user;

import java.util.UUID;

public record UserResponseClient(UUID id, String name, String email) {
}
