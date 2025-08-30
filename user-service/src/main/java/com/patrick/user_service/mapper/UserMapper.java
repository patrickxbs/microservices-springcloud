package com.patrick.user_service.mapper;

import com.patrick.user_service.dto.UserRequest;
import com.patrick.user_service.dto.UserResponse;
import com.patrick.user_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toUser(UserRequest userRequest);

    UserResponse toResponse(User user);
}
