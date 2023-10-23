package com.finance.finance_control_api.domain.transactions.Category;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(@NotBlank String name) {
}
