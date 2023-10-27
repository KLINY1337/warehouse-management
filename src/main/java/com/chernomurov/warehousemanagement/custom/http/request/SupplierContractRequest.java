package com.chernomurov.warehousemanagement.custom.http.request;

import com.chernomurov.warehousemanagement.custom.http.DTO.SupplierDto;
import com.chernomurov.warehousemanagement.custom.http.DTO.UserDto;

import java.time.LocalDateTime;

public record SupplierContractRequest(
        Long shipmentId,
        SupplierDto supplier,
        UserDto responsibleUser,
        LocalDateTime deliveryTime,
        LocalDateTime storageTime,
        String storingConditions) {
}
