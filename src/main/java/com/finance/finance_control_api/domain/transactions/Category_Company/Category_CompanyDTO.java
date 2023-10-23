package com.finance.finance_control_api.domain.transactions.Category_Company;

import jakarta.validation.constraints.NotBlank;

public record Category_CompanyDTO(@NotBlank String company_id, @NotBlank String category_id) {
}
