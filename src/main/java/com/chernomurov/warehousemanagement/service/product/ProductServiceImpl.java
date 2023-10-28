package com.chernomurov.warehousemanagement.service.product;

import com.chernomurov.warehousemanagement.custom.http.DTO.UserRoleDto;
import com.chernomurov.warehousemanagement.custom.http.request.ProductRequest;
import com.chernomurov.warehousemanagement.custom.http.request.UserRequest;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.entity.UserRole;
import com.chernomurov.warehousemanagement.entity.WorkingTeam;
import com.chernomurov.warehousemanagement.repository.ProductRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequest request) {
        Product product = getProductFromRequest(null, request);
        return productRepository.save(product);
    }

    @Override
    public Product getProductByArticleNumber(String articleNumber) {
        return productRepository.findById(articleNumber).orElseThrow(() -> new EntityNotFoundException("Товар с id " + articleNumber + " не найден, действие отменено."));
    }

    @Override
    public Product updateProduct(String articleNumber, ProductRequest request) {
        Product product = getProductFromRequest(articleNumber, request);
        if (productRepository.existsById(articleNumber)){
            return productRepository.save(product);
        }
        else {
            throw new  EntityNotFoundException("Товар с id " + articleNumber + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteProductByArticleNumber(String articleNumber) {
        if (productRepository.existsById(articleNumber)){
            productRepository.deleteById(articleNumber);
        }
        else {
            throw new  EntityNotFoundException("Товар с id " + articleNumber + " не найден, действие отменено.");
        }
    }

    private Product getProductFromRequest(String articleNumber, ProductRequest request) {

        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("articleNumber");
        fieldNamesToValidate.add("name");
        fieldNamesToValidate.add("price");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        return Product.builder()
                .articleNumber(articleNumber)
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();
    }
}
