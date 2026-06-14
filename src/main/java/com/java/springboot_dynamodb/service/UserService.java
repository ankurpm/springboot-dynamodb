package com.java.springboot_dynamodb.service;

import com.java.springboot_dynamodb.model.UserResponse;
import com.java.springboot_dynamodb.repository.UserRepository;
import com.java.springboot_dynamodb.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User createUser(String name) {

        User user = new User();

        user.setId(UUID.randomUUID().toString());
        user.setName(name);

        repository.save(user);

        return user;
    }

    public List<UserResponse> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private UserResponse toResponse(User user){
        return new UserResponse(user.getId(), user.getName());
    }
}
