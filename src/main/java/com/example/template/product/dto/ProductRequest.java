package com.example.template.product.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank @Size(max = 30) String sku,
        @NotBlank @Size(max = 150) String name,
        @Size(max = 500) String description,
        @NotBlank @Size(max = 80) String category,
        @Size(max = 80) String brand,
        @NotNull @DecimalMin(value = "0.0", inclusive = true) BigDecimal price,
        @Size(min = 3, max = 3) String currency,
        Integer stockQuantity,
        Boolean active) {
}
