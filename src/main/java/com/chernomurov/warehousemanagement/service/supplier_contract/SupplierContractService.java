package com.chernomurov.warehousemanagement.service.supplier_contract;

import com.chernomurov.warehousemanagement.custom.http.request.SupplierContractRequest;
import com.chernomurov.warehousemanagement.entity.*;

import java.time.LocalDateTime;

public interface SupplierContractService {
    SupplierContract createSupplierContract(SupplierContractRequest request);
    SupplierContract getSupplierContractByShipment(Shipment shipment);
    SupplierContract updateSupplierContract(Shipment shipment, SupplierContractRequest request);
    void deleteSupplierContractByShipment(Shipment shipment);
}
