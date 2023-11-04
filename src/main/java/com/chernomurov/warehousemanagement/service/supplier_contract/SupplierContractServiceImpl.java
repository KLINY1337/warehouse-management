package com.chernomurov.warehousemanagement.service.supplier_contract;

import com.chernomurov.warehousemanagement.custom.http.request.OrderingRequest;
import com.chernomurov.warehousemanagement.custom.http.request.SupplierContractRequest;
import com.chernomurov.warehousemanagement.entity.*;
import com.chernomurov.warehousemanagement.repository.SupplierContractRepository;
import com.chernomurov.warehousemanagement.repository.SupplierRepository;
import com.chernomurov.warehousemanagement.repository.UserRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierContractServiceImpl implements SupplierContractService {

    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;
    private final SupplierContractRepository supplierContractRepository;

    @Override
    public SupplierContract createSupplierContract(Shipment shipment, SupplierContractRequest request) {
        SupplierContract supplierContract = getSupplierContractFromRequest(shipment, request);
        return supplierContractRepository.save(supplierContract);
    }

    @Override
    public SupplierContract getSupplierContractByShipment(Shipment shipment) {
        return supplierContractRepository.findById(shipment.getId()).orElseThrow(() -> new EntityNotFoundException("Договор с id " + shipment.getId() + " не найден, действие отменено."));
    }

    @Override
    public SupplierContract updateSupplierContract(Shipment shipment, SupplierContractRequest request) {
        SupplierContract supplierContract = getSupplierContractFromRequest(shipment, request);

        if (supplierContractRepository.existsById(shipment.getId())){
            return supplierContractRepository.save(supplierContract);
        }
        else {
            throw new  EntityNotFoundException("Договор с id " + shipment.getId() + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteSupplierContractByShipment(Shipment shipment) {
        if (supplierContractRepository.existsById(shipment.getId())){
            supplierContractRepository.deleteById(shipment.getId());
        }
        else {
            throw new  EntityNotFoundException("Договор с id " + shipment.getId() + " не найден, действие отменено.");
        }
    }

    private SupplierContract getSupplierContractFromRequest(Shipment shipment, SupplierContractRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("supplier");
        fieldNamesToValidate.add("responsibleUser");
        fieldNamesToValidate.add("deliveryTime");
        fieldNamesToValidate.add("storageTime");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        Supplier supplier = supplierRepository
                .findById(request.supplier().id())
                .orElseThrow(() -> new EntityNotFoundException("Поставщик с id " + request.supplier().id() + " не найден, действие отменено."));
        User responsibleUser = userRepository
                .findById(request.responsibleUser().id())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + request.responsibleUser().id() + " не найден, действие отменено."));

        return SupplierContract.builder()
                .shipmentId(shipment.getId())
                .supplier(supplier)
                .responsibleUser(responsibleUser)
                .deliveryTime(request.deliveryTime())
                .storageTime(request.storageTime())
                .storingConditions(request.storingConditions())
                .build();
    }
}
