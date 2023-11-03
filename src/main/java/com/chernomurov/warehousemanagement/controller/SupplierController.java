package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.SupplierRequest;
import com.chernomurov.warehousemanagement.entity.Supplier;
import com.chernomurov.warehousemanagement.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping
    public Supplier createSupplier(@RequestBody SupplierRequest request) {
        return supplierService.createSupplier(request);
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    public Supplier updateSupplier(@PathVariable Long id, @RequestBody SupplierRequest request) {
        return supplierService.updateSupplier(id, request);
    }

    public void deleteSupplierById(@PathVariable Long id) {
        supplierService.deleteSupplierById(id);
    }
}
