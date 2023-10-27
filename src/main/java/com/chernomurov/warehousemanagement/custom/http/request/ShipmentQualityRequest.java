package com.chernomurov.warehousemanagement.custom.http.request;

import java.math.BigDecimal;

public record ShipmentQualityRequest(
        Long shipmentId,
        BigDecimal qualityCoefficient) {
}
