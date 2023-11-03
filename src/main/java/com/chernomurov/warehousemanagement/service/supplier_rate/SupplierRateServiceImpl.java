package com.chernomurov.warehousemanagement.service.supplier_rate;

import com.chernomurov.warehousemanagement.custom.http.request.ProductCurrentAmountRequest;
import com.chernomurov.warehousemanagement.custom.http.request.SupplierRateRequest;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductCurrentAmount;
import com.chernomurov.warehousemanagement.entity.Supplier;
import com.chernomurov.warehousemanagement.entity.SupplierRate;
import com.chernomurov.warehousemanagement.repository.SupplierRateRepository;
import com.chernomurov.warehousemanagement.repository.SupplierRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierRateServiceImpl implements SupplierRateService {

    private final SupplierRateRepository supplierRateRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public SupplierRate createSupplierRate(Supplier supplier, SupplierRateRequest request) {
        SupplierRate supplierRate = getSupplierRateFromRequest(supplier, request);
        return supplierRateRepository.save(supplierRate);
    }

    @Override
    public SupplierRate getSupplierRateBySupplier(Supplier supplier) {
        return supplierRateRepository.findById(supplier.getId()).orElseThrow(() -> new EntityNotFoundException("Поставщик с id " + supplier.getId() + " не найден, действие отменено."));
    }

    @Override
    public SupplierRate updateSupplierRate(Supplier supplier, SupplierRateRequest request) {
        SupplierRate supplierRate = getSupplierRateFromRequest(supplier, request);

        if (supplierRateRepository.existsById(supplier.getId())){
            return supplierRateRepository.save(supplierRate);
        }
        else {
            throw new  EntityNotFoundException("Поставщик с id " + supplier.getId() + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteSupplierRateBySupplier(Supplier supplier) {
        if (supplierRateRepository.existsById(supplier.getId())){
            supplierRateRepository.deleteById(supplier.getId());
        }
        else {
            throw new  EntityNotFoundException("Поставщик с id " + supplier.getId() + " не найден, действие отменено.");
        }
    }

    private SupplierRate getSupplierRateFromRequest(Supplier supplier, SupplierRateRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        //fieldNamesToValidate.add("productArticleNumber");
        fieldNamesToValidate.add("reliabilityRate");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        supplierRepository.findById(supplier.getId()).orElseThrow(() -> new EntityNotFoundException("Поставщик с id " + supplier.getId() + " не найден, действие отменено."));

        return SupplierRate.builder()
                .reliabilityRate(request.reliabilityRate())
                .supplierId(supplier.getId())
                .build();
    }
}
