package com.chernomurov.warehousemanagement.custom.http.request;

public record ProductCurrentAmountRequest(
        String productArticleNumber,
        Long currentAmount) {
}
