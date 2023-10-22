package com.chernomurov.warehousemanagement.service.supplier;

import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.StockManagement;
import com.chernomurov.warehousemanagement.entity.Supplier;
import com.chernomurov.warehousemanagement.entity.User;

public interface SupplierService {
    void createSupplier(String name);
    Supplier getSupplierById(Long id);
    void updateSupplier(Long id, String name);
    void deleteSupplierById(Long id);
}
