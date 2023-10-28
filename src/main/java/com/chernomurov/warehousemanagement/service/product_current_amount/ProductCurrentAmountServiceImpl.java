package com.chernomurov.warehousemanagement.service.product_current_amount;

import com.chernomurov.warehousemanagement.custom.http.request.ProductCurrentAmountRequest;
import com.chernomurov.warehousemanagement.entity.Ordering;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductCurrentAmount;
import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.repository.ProductCurrentAmountRepository;
import com.chernomurov.warehousemanagement.repository.ProductRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCurrentAmountServiceImpl implements ProductCurrentAmountService {

    private final ProductCurrentAmountRepository productCurrentAmountRepository;
    private final ProductRepository productRepository;

    @Override
    public ProductCurrentAmount createProductCurrentAmount(Product product, ProductCurrentAmountRequest request) {
        ProductCurrentAmount productCurrentAmount = getProductCurrentAmountFromRequest(product, request);
        return productCurrentAmountRepository.save(productCurrentAmount);
    }

    @Override
    public ProductCurrentAmount getProductCurrentAmountByProduct(Product product) {
        return productCurrentAmountRepository.findById(product.getArticleNumber()).orElseThrow(() -> new EntityNotFoundException("Товар с id " + product.getArticleNumber() + " не найден, действие отменено."));
    }

    @Override
    public ProductCurrentAmount updateProductCurrentAmount(Product product, ProductCurrentAmountRequest request) {
        ProductCurrentAmount productCurrentAmount = getProductCurrentAmountFromRequest(product, request);

        if (productCurrentAmountRepository.existsById(product.getArticleNumber())){
            return productCurrentAmountRepository.save(productCurrentAmount);
        }
        else {
            throw new  EntityNotFoundException("Товар с id " + product.getArticleNumber() + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteProductCurrentAmountByProduct(Product product) {
        if (productCurrentAmountRepository.existsById(product.getArticleNumber())){
            productCurrentAmountRepository.deleteById(product.getArticleNumber());
        }
        else {
            throw new  EntityNotFoundException("Товар с id " + product.getArticleNumber() + " не найден, действие отменено.");
        }
    }

    private ProductCurrentAmount getProductCurrentAmountFromRequest(Product product, ProductCurrentAmountRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        //fieldNamesToValidate.add("productArticleNumber");
        fieldNamesToValidate.add("currentAmount");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        productRepository.findById(product.getArticleNumber()).orElseThrow(() -> new EntityNotFoundException("Товар с id " + product.getArticleNumber() + " не найден, действие отменено."));

        return ProductCurrentAmount.builder()
                .productArticleNumber(product.getArticleNumber())
                .currentAmount(request.currentAmount())
                .build();
    }
}
