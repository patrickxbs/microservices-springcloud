package com.patrick.booking_service.client;

import com.patrick.booking_service.dto.user.UserResponseClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/users/{userId}")
    UserResponseClient findUserById(@PathVariable UUID userId);
}
