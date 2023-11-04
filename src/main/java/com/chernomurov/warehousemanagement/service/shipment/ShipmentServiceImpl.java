package com.chernomurov.warehousemanagement.service.shipment;

import com.chernomurov.warehousemanagement.custom.http.DTO.UserRoleDto;
import com.chernomurov.warehousemanagement.custom.http.DTO.WorkingTeamDto;
import com.chernomurov.warehousemanagement.custom.http.request.OrderingRequest;
import com.chernomurov.warehousemanagement.custom.http.request.ShipmentRequest;
import com.chernomurov.warehousemanagement.entity.*;
import com.chernomurov.warehousemanagement.repository.ProductRepository;
import com.chernomurov.warehousemanagement.repository.ShipmentRepository;
import com.chernomurov.warehousemanagement.repository.WorkingTeamRepository;
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
public class ShipmentServiceImpl implements ShipmentService {

    private final ProductRepository productRepository;
    private final WorkingTeamRepository workingTeamRepository;
    private final ShipmentRepository shipmentRepository;

    @Override
    public Shipment createShipment(ShipmentRequest request) {
        Shipment shipment = getShipmentFromRequest(null, request);
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Поставка с id " + id + " не найден, действие отменено."));
    }

    @Override
    public Shipment updateShipment(Long id, ShipmentRequest request) {
        Shipment shipment = getShipmentFromRequest(id, request);

        if (shipmentRepository.existsById(id)){
            return shipmentRepository.save(shipment);
        }
        else {
            throw new  EntityNotFoundException("Поставка с id " + id + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteShipmentById(Long id) {
        if (shipmentRepository.existsById(id)){
            shipmentRepository.deleteById(id);
        }
        else {
            throw new  EntityNotFoundException("Поставка с id " + id + " не найден, действие отменено.");
        }
    }

    private Shipment getShipmentFromRequest(Long id, ShipmentRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("product");
        fieldNamesToValidate.add("amount");
        fieldNamesToValidate.add("workingTeams");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        Product product = productRepository
                .findById(request.product().articleNumber())
                .orElseThrow(() -> new EntityNotFoundException("Товар с id " + request.product().articleNumber() + " не найден, действие отменено."));

        Set<WorkingTeam> workingTeams = new HashSet<>();
        for (WorkingTeamDto e : request.workingTeams()) {
            WorkingTeam workingTeam = workingTeamRepository.findById(e.id())
                    .orElseThrow(() -> new EntityNotFoundException("Бригада с id " + e.id() + " не найдено, действие отменено."));
            workingTeams.add(workingTeam);
        }

        return Shipment.builder()
                .id(id)
                .product(product)
                .amount(request.amount())
                .workingTeams(workingTeams)
                .build();
    }
}
