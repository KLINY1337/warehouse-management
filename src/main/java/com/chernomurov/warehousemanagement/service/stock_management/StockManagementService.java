package com.chernomurov.warehousemanagement.service.stock_management;

import com.chernomurov.warehousemanagement.entity.*;

import java.math.BigDecimal;

public interface StockManagementService {
    void createStockManagement(Product product, Integer additionalBuyAmount, User responsibleUser);
    StockManagement getStockManagementById(Long id);
    void updateStockManagement(Long id, Product product, Integer additionalBuyAmount, User responsibleUser);
    void deleteStockManagementById(Long id);
}
