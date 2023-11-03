package com.chernomurov.warehousemanagement.service.stock_management;

import com.chernomurov.warehousemanagement.custom.http.request.ProductMinimalAmountRequest;
import com.chernomurov.warehousemanagement.custom.http.request.StockManagementRequest;
import com.chernomurov.warehousemanagement.entity.*;
import com.chernomurov.warehousemanagement.repository.ProductRepository;
import com.chernomurov.warehousemanagement.repository.StockManagementRepository;
import com.chernomurov.warehousemanagement.repository.UserRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockManagementServiceImpl implements StockManagementService {

    private final StockManagementRepository stockManagementRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public StockManagement createStockManagement(StockManagementRequest request) {
        StockManagement stockManagement = getStockManagementFromRequest(null, request);
        return stockManagementRepository.save(stockManagement);
    }

    @Override
    public StockManagement getStockManagementById(Long id) {
        return stockManagementRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Корректировка запасов с id " + id + " не найден, действие отменено."));
    }

    @Override
    public StockManagement updateStockManagement(Long id, StockManagementRequest request) {
        StockManagement stockManagement = getStockManagementFromRequest(id, request);

        if (stockManagementRepository.existsById(id)){
            return stockManagementRepository.save(stockManagement);
        }
        else {
            throw new  EntityNotFoundException("Корректировка запасов с id " + id + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteStockManagementById(Long id) {
        if (stockManagementRepository.existsById(id)){
            stockManagementRepository.deleteById(id);
        }
        else {
            throw new  EntityNotFoundException("Корректировка запасов с id " + id + " не найден, действие отменено.");
        }
    }

    private StockManagement getStockManagementFromRequest(Long id, StockManagementRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("additionalBuyAmount");
        fieldNamesToValidate.add("product");
        fieldNamesToValidate.add("responsibleUser");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        Product product = productRepository
                .findById(request.product().articleNumber())
                .orElseThrow(() -> new EntityNotFoundException("Товар с id " + request.product().articleNumber() + " не найден, действие отменено."));
        User responsibleUser = userRepository
                .findById(request.responsibleUser().id())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + request.responsibleUser().id() + " не найден, действие отменено."));

        return StockManagement.builder()
                .id(id)
                .product(product)
                .additionalBuyAmount(request.additionalBuyAmount())
                .responsibleUser(responsibleUser)
                .build();
    }
}
