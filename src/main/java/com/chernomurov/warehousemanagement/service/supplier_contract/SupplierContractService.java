package com.chernomurov.warehousemanagement.service.supplier_contract;

import com.chernomurov.warehousemanagement.entity.*;

import java.time.LocalDateTime;

public interface SupplierContractService {
    void createSupplierContract(Shipment shipment, Supplier supplier, LocalDateTime deliveryTime, LocalDateTime storageTime, String storingConditions, User responsibleUser);
    SupplierContract getSupplierContractByShipment(Shipment shipment);
    void updateSupplierContract(Shipment shipment, Supplier supplier, LocalDateTime deliveryTime, LocalDateTime storageTime, String storingConditions, User responsibleUser);
    void deleteSupplierContractByShipment(Shipment shipment);
}
