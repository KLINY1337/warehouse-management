package com.chernomurov.warehousemanagement.service.supplier_rate;

import com.chernomurov.warehousemanagement.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface SupplierRateService {
    void createSupplierRate(Supplier supplier, BigDecimal reliabilityRate);
    SupplierRate getSupplierRateBySupplier(Supplier supplier);
    void updateSupplierRate(Supplier supplier, BigDecimal reliabilityRate);
    void deleteSupplierRateBySupplier(Supplier supplier);
}
