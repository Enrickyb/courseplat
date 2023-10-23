package com.courseplat.courseplat.domain.user;

import jakarta.validation.constraints.NotBlank;


public record UserDto(@NotBlank String name, @NotBlank String email, @NotBlank String password, UserRole role) {

}
