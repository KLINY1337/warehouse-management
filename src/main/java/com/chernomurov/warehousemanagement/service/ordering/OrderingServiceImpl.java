package com.chernomurov.warehousemanagement.service.ordering;

import com.chernomurov.warehousemanagement.custom.http.request.OrderingRequest;
import com.chernomurov.warehousemanagement.entity.Ordering;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.User;
import com.chernomurov.warehousemanagement.repository.OrderingRepository;
import com.chernomurov.warehousemanagement.repository.ProductRepository;
import com.chernomurov.warehousemanagement.repository.UserRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderingServiceImpl implements OrderingService {

    private final OrderingRepository orderingRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public Ordering createOrder(OrderingRequest request) {
        Ordering ordering = getOrderingFromRequest(null, request);
        return orderingRepository.save(ordering);
    }

    @Override
    public Ordering getOrderById(Long id) {
        return orderingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Заказ с id " + id + " не найден, действие отменено."));
    }

    @Override
    public Ordering updateOrder(Long id, OrderingRequest request) {
        Ordering ordering = getOrderingFromRequest(id, request);

        if (orderingRepository.existsById(id)){
            return orderingRepository.save(ordering);
        }
        else {
            throw new  EntityNotFoundException("Заказ с id " + id + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteOrderById(Long id) {
        if (orderingRepository.existsById(id)){
            orderingRepository.deleteById(id);
        }
        else {
            throw new  EntityNotFoundException("Заказ с id " + id + " не найден, действие отменено.");
        }
    }

    private Ordering getOrderingFromRequest(Long id, OrderingRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("product");
        fieldNamesToValidate.add("consumer");
        fieldNamesToValidate.add("responsibleUser");
        fieldNamesToValidate.add("date");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        Product product = productRepository
                .findById(request.product().articleNumber())
                .orElseThrow(() -> new EntityNotFoundException("Товар с id " + request.product().articleNumber() + " не найден, действие отменено."));
        User responsibleUser = userRepository
                .findById(request.responsibleUser().id())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + request.responsibleUser().id() + " не найден, действие отменено."));

        return Ordering.builder()
                .id(id)
                .product(product)
                .consumer(request.consumer())
                .amount(request.amount())
                .date(request.date())
                .responsibleUser(responsibleUser)
                .build();
    }
}
