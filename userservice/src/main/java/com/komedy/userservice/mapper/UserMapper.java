package com.komedy.userservice.mapper;

import com.komedy.userservice.dto.CreateUserRequest;
import com.komedy.userservice.dto.UserResponse;
import com.komedy.userservice.entity.User;

public class UserMapper {

    public static User toEntity(CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        return user;
    }

    public static UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());
        return userResponse;
    }
}
