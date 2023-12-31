package com.chernomurov.warehousemanagement.controller;


import com.chernomurov.warehousemanagement.custom.http.request.SupplierContractRequest;
import com.chernomurov.warehousemanagement.entity.Shipment;
import com.chernomurov.warehousemanagement.entity.SupplierContract;
import com.chernomurov.warehousemanagement.service.supplier_contract.SupplierContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/supplier/contract")
public class SupplierContractController {

    private final SupplierContractService supplierContractService;

    @PostMapping("/{shipment:\\d+}")
    public ResponseEntity<SupplierContract> createSupplierContract(@PathVariable("shipment") Shipment shipment, @RequestBody SupplierContractRequest request) {
        return ResponseEntity.ok(supplierContractService.createSupplierContract(shipment, request));
    }

    @GetMapping("/{shipment:\\d+}")
    public ResponseEntity<SupplierContract> getSupplierContractByShipment(@PathVariable("shipment") Shipment shipment) {
        return ResponseEntity.ok(supplierContractService.getSupplierContractByShipment(shipment));
    }

    @PutMapping("/{shipment:\\d+}")
    public ResponseEntity<SupplierContract> updateSupplierContract(@PathVariable("shipment") Shipment shipment, @RequestBody SupplierContractRequest request) {
        return ResponseEntity.ok(supplierContractService.updateSupplierContract(shipment, request));
    }

    @DeleteMapping("/{shipment:\\d+}")
    public void deleteSupplierContractByShipment(@PathVariable("shipment") Shipment shipment) {
        supplierContractService.deleteSupplierContractByShipment(shipment);
    }
}
