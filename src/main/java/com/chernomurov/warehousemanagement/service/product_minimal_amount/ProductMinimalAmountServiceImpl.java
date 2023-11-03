package com.chernomurov.warehousemanagement.service.product_minimal_amount;

import com.chernomurov.warehousemanagement.custom.http.request.ProductCurrentAmountRequest;
import com.chernomurov.warehousemanagement.custom.http.request.ProductMinimalAmountRequest;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductCurrentAmount;
import com.chernomurov.warehousemanagement.entity.ProductMinimalAmount;
import com.chernomurov.warehousemanagement.repository.ProductMinimalAmountRepository;
import com.chernomurov.warehousemanagement.repository.ProductRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductMinimalAmountServiceImpl implements ProductMinimalAmountService {

    private final ProductRepository productRepository;
    private final ProductMinimalAmountRepository productMinimalAmountRepository;

    @Override
    public ProductMinimalAmount createProductMinimalAmount(Product product, ProductMinimalAmountRequest request) {
        ProductMinimalAmount productMinimalAmount = getProductMinimalAmountFromRequest(product, request);
        return productMinimalAmountRepository.save(productMinimalAmount);
    }

    @Override
    public ProductMinimalAmount getProductMinimalAmountByProduct(Product product) {
        return productMinimalAmountRepository.findById(product.getArticleNumber()).orElseThrow(() -> new EntityNotFoundException("Товар с id " + product.getArticleNumber() + " не найден, действие отменено."));
    }

    @Override
    public ProductMinimalAmount updateProductMinimalAmount(Product product, ProductMinimalAmountRequest request) {
        ProductMinimalAmount productMinimalAmount = getProductMinimalAmountFromRequest(product, request);

        if (productMinimalAmountRepository.existsById(product.getArticleNumber())){
            return productMinimalAmountRepository.save(productMinimalAmount);
        }
        else {
            throw new  EntityNotFoundException("Товар с id " + product.getArticleNumber() + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteProductMinimalAmountByProduct(Product product) {
        if (productMinimalAmountRepository.existsById(product.getArticleNumber())){
            productMinimalAmountRepository.deleteById(product.getArticleNumber());
        }
        else {
            throw new  EntityNotFoundException("Товар с id " + product.getArticleNumber() + " не найден, действие отменено.");
        }
    }

    private ProductMinimalAmount getProductMinimalAmountFromRequest(Product product, ProductMinimalAmountRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        //fieldNamesToValidate.add("productArticleNumber");
        fieldNamesToValidate.add("minimalAmount");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        productRepository.findById(product.getArticleNumber()).orElseThrow(() -> new EntityNotFoundException("Товар с id " + product.getArticleNumber() + " не найден, действие отменено."));

        return ProductMinimalAmount.builder()
                .productArticleNumber(product.getArticleNumber())
                .minimalAmount(request.minimalAmount())
                .build();
    }
}
