package com.chernomurov.warehousemanagement.custom.http.request;

import com.chernomurov.warehousemanagement.custom.http.DTO.ProductDto;
import com.chernomurov.warehousemanagement.custom.http.DTO.UserDto;

public record StockManagementRequest(
        Long id,
        ProductDto product,
        Integer additionalBuyAmount,
        UserDto responsibleUser) {
}
