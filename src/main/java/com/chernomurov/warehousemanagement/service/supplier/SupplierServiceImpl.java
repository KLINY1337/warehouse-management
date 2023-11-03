package com.chernomurov.warehousemanagement.service.supplier;

import com.chernomurov.warehousemanagement.custom.http.request.SupplierRequest;
import com.chernomurov.warehousemanagement.entity.EquipmentType;
import com.chernomurov.warehousemanagement.entity.Supplier;
import com.chernomurov.warehousemanagement.repository.SupplierRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(SupplierRequest request) {
        Supplier supplier = getSupplierFromRequest(null, request);
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Поставщик с id " + id + " не найден, действие отменено."));
    }

    @Override
    public Supplier updateSupplier(Long id, SupplierRequest request) {
        Supplier supplier = getSupplierFromRequest(id, request);

        if (supplierRepository.existsById(id)){
            return supplierRepository.save(supplier);
        }
        else {
            throw new  EntityNotFoundException("Поставщик с id " + id + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteSupplierById(Long id) {
        if (supplierRepository.existsById(id)){
            supplierRepository.deleteById(id);
        }
        else {
            throw new  EntityNotFoundException("Поставщик с id " + id + " не найден, действие отменено.");
        }
    }

    private Supplier getSupplierFromRequest(Long id, SupplierRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("name");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        return Supplier.builder()
                .id(id)
                .name(request.name())
                .build();
    }
}
