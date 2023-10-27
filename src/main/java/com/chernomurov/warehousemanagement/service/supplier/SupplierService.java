package com.chernomurov.warehousemanagement.service.supplier;

import com.chernomurov.warehousemanagement.custom.http.request.SupplierRequest;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.StockManagement;
import com.chernomurov.warehousemanagement.entity.Supplier;
import com.chernomurov.warehousemanagement.entity.User;

public interface SupplierService {
    Supplier createSupplier(SupplierRequest request);
    Supplier getSupplierById(Long id);
    Supplier updateSupplier(Long id, SupplierRequest request);
    void deleteSupplierById(Long id);
}
