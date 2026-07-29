package com.komedy.userservice.service;

import com.komedy.userservice.dto.CreateUserRequest;
import com.komedy.userservice.dto.UserResponse;
import com.komedy.userservice.entity.User;
import com.komedy.userservice.exception.UserAlreadyExistsException;
import com.komedy.userservice.exception.UserNotFoundException;
import com.komedy.userservice.mapper.UserMapper;
import com.komedy.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(CreateUserRequest request) {

        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(
                    "User already exists with email: " + request.getEmail());
        }
        User user = UserMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return UserMapper.toResponse(savedUser);
    }

    public UserResponse getUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        return UserMapper.toResponse(user);
    }
}
