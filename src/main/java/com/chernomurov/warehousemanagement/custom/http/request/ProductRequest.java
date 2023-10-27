package com.chernomurov.warehousemanagement.custom.http.request;

import java.math.BigDecimal;

public record ProductRequest(
        String articleNumber,
        String name,
        String description,
        BigDecimal price) {
}
