package com.patrick.user_service.dto;

import java.util.UUID;

public record UserResponse(UUID id, String name, String email) {

}
