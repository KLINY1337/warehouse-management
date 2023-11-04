package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.SupplierRateRequest;
import com.chernomurov.warehousemanagement.entity.Supplier;
import com.chernomurov.warehousemanagement.entity.SupplierRate;
import com.chernomurov.warehousemanagement.service.supplier_rate.SupplierRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/supplier/rate")
public class SupplierRateController {

    private final SupplierRateService supplierRateService;

    @PostMapping("/{supplier:\\d+}")
    public ResponseEntity<SupplierRate> createSupplierRate(@PathVariable Supplier supplier, @RequestBody SupplierRateRequest request) {
        return ResponseEntity.ok(supplierRateService.createSupplierRate(supplier, request));
    }

    @GetMapping("/{supplier:\\d+}")
    public ResponseEntity<SupplierRate> getSupplierRateBySupplier(@PathVariable Supplier supplier) {
        return ResponseEntity.ok(supplierRateService.getSupplierRateBySupplier(supplier));
    }

    @PutMapping("/{supplier:\\d+}")
    public ResponseEntity<SupplierRate> updateSupplierRate(@PathVariable Supplier supplier, @RequestBody SupplierRateRequest request) {
        return ResponseEntity.ok(supplierRateService.updateSupplierRate(supplier, request));
    }

    @DeleteMapping("/{supplier:\\d+}")
    public void deleteSupplierRateBySupplier(@PathVariable Supplier supplier) {
        supplierRateService.deleteSupplierRateBySupplier(supplier);
    }
}
