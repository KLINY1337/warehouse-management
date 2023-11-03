package com.chernomurov.warehousemanagement.controller;

import com.chernomurov.warehousemanagement.custom.http.request.StockManagementRequest;
import com.chernomurov.warehousemanagement.entity.StockManagement;
import com.chernomurov.warehousemanagement.service.stock_management.StockManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/stock/management")
public class StockManagementController {

    private final StockManagementService stockManagementService;

    @PostMapping
    public StockManagement createStockManagement(@RequestBody StockManagementRequest request) {
        return stockManagementService.createStockManagement(request);
    }

    @GetMapping("/{id}")
    public StockManagement getStockManagementById(@PathVariable Long id) {
        return stockManagementService.getStockManagementById(id);
    }

    @PutMapping("/{id}")
    public StockManagement updateStockManagement(@PathVariable Long id, @RequestBody StockManagementRequest request) {
        return stockManagementService.updateStockManagement(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteStockManagementById(@PathVariable Long id) {
        stockManagementService.deleteStockManagementById(id);
    }
}
