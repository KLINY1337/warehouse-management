package com.chernomurov.warehousemanagement.custom.http.request;

public record ProductMinimalAmountRequest(
        String productArticleNumber,
        Integer minimalAmount) {
}
