package com.java.springboot_dynamodb.model;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(

        @NotBlank
        String name

) {
}
