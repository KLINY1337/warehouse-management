package com.chernomurov.warehousemanagement.custom.http.request;

import java.math.BigDecimal;

public record SupplierRateRequest(
        Long supplierId,
        BigDecimal reliabilityRate) {
}
