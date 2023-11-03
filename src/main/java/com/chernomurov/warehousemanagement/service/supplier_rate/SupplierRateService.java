package com.chernomurov.warehousemanagement.service.supplier_rate;

import com.chernomurov.warehousemanagement.custom.http.request.SupplierRateRequest;
import com.chernomurov.warehousemanagement.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface SupplierRateService {
    SupplierRate createSupplierRate(Supplier supplier, SupplierRateRequest request);
    SupplierRate getSupplierRateBySupplier(Supplier supplier);
    SupplierRate updateSupplierRate(Supplier supplier, SupplierRateRequest request);
    void deleteSupplierRateBySupplier(Supplier supplier);
}
