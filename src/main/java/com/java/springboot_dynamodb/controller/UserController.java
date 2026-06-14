package com.java.springboot_dynamodb.controller;

import com.java.springboot_dynamodb.model.CreateUserRequest;
import com.java.springboot_dynamodb.model.User;
import com.java.springboot_dynamodb.model.UserResponse;
import com.java.springboot_dynamodb.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public UserResponse create(
            @Valid @RequestBody CreateUserRequest request) {

        User user = service.createUser(request.name());

        return new UserResponse(
                user.getId(),
                user.getName()
        );
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){
        var users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
