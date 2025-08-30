package com.patrick.user_service.service;

import com.patrick.user_service.dto.UserRequest;
import com.patrick.user_service.dto.UserResponse;
import com.patrick.user_service.mapper.UserMapper;
import com.patrick.user_service.model.User;
import com.patrick.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toUser(request);
        return userMapper.toResponse(userRepository.save(user));
    }
}
