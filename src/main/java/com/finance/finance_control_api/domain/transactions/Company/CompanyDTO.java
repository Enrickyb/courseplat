package com.finance.finance_control_api.domain.transactions.Company;

import jakarta.validation.constraints.NotBlank;

public record CompanyDTO(@NotBlank String name, String image, String category_id) {
}
