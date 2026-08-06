package com.example.template.product.dto;

import com.example.template.product.model.Product;

import java.math.BigDecimal;
import java.time.Instant;

public record ProductResponse(
        Long id,
        String sku,
        String name,
        String description,
        String category,
        String brand,
        BigDecimal price,
        String currency,
        Integer stockQuantity,
        Boolean active,
        Instant createdAt,
        Instant updatedAt) {


    public static ProductResponse from(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getSku(),
                p.getName(),
                p.getDescription(),
                p.getCategory(),
                p.getBrand(),
                p.getPrice(),
                p.getCurrency(),
                p.getStockQuantity(),
                p.getActive(),
                p.getCreatedAt(),
                p.getUpdatedAt()
        );
    }
}
