package com.chernomurov.warehousemanagement.service.stock_management;

import com.chernomurov.warehousemanagement.custom.http.request.StockManagementRequest;
import com.chernomurov.warehousemanagement.entity.*;

import java.math.BigDecimal;

public interface StockManagementService {
    StockManagement createStockManagement(StockManagementRequest request);
    StockManagement getStockManagementById(Long id);
    StockManagement updateStockManagement(Long id, StockManagementRequest request);
    void deleteStockManagementById(Long id);
}
