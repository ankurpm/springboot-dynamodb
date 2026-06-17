package com.java.springboot_dynamodb.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(

        @NotBlank
        String name

) {
}
