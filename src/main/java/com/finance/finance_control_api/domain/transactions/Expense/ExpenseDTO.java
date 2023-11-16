package com.finance.finance_control_api.domain.transactions.Expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExpenseDTO(String title, String description, String company_id, @NotBlank String user_id, @NotNull float value, @NotBlank String date) {
}
