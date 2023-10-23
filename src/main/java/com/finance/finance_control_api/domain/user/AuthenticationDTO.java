package com.finance.finance_control_api.domain.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(@NotBlank String email, @NotBlank String password) {

}
