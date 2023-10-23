package com.courseplat.courseplat.domain.transactions.Category;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(@NotBlank String name) {
}
