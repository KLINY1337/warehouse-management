package com.chernomurov.warehousemanagement.service.shipment_quality;

import com.chernomurov.warehousemanagement.custom.http.request.ProductMinimalAmountRequest;
import com.chernomurov.warehousemanagement.custom.http.request.ShipmentQualityRequest;
import com.chernomurov.warehousemanagement.entity.Product;
import com.chernomurov.warehousemanagement.entity.ProductMinimalAmount;
import com.chernomurov.warehousemanagement.entity.Shipment;
import com.chernomurov.warehousemanagement.entity.ShipmentQuality;
import com.chernomurov.warehousemanagement.repository.ShipmentQualityRepository;
import com.chernomurov.warehousemanagement.repository.ShipmentRepository;
import com.chernomurov.warehousemanagement.util.RequestUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentQualityServiceImpl implements ShipmentQualityService {

    private final ShipmentRepository shipmentRepository;
    private final ShipmentQualityRepository shipmentQualityRepository;

    @Override
    public ShipmentQuality createShipmentQuality(Shipment shipment, ShipmentQualityRequest request) {
        ShipmentQuality shipmentQuality = getShipmentQualityFromRequest(shipment, request);
        return shipmentQualityRepository.save(shipmentQuality);
    }

    @Override
    public ShipmentQuality getShipmentQualityByShipment(Shipment shipment) {
        return shipmentQualityRepository.findById(shipment.getId()).orElseThrow(() -> new EntityNotFoundException("Качество поставки с id " + shipment.getId() + " не найден, действие отменено."));
    }

    @Override
    public ShipmentQuality updateShipmentQuality(Shipment shipment, ShipmentQualityRequest request) {
        ShipmentQuality shipmentQuality = getShipmentQualityFromRequest(shipment, request);

        if (shipmentQualityRepository.existsById(shipment.getId())){
            return shipmentQualityRepository.save(shipmentQuality);
        }
        else {
            throw new EntityNotFoundException("Качество поставки с id " + shipment.getId() + " не найден, действие отменено.");
        }
    }

    @Override
    public void deleteShipmentQualityByShipment(Shipment shipment) {
        if (shipmentQualityRepository.existsById(shipment.getId())){
            shipmentQualityRepository.deleteById(shipment.getId());
        }
        else {
            throw new  EntityNotFoundException("Качество поставки с id " + shipment.getId() + " не найден, действие отменено.");
        }
    }

    private ShipmentQuality getShipmentQualityFromRequest(Shipment shipment, ShipmentQualityRequest request) {
        List<String> fieldNamesToValidate = new ArrayList<>();
        fieldNamesToValidate.add("qualityCoefficient");
        RequestUtils.validateRequest(request, fieldNamesToValidate);

        shipmentRepository.findById(shipment.getId()).orElseThrow(() -> new EntityNotFoundException("Поставка с id " + shipment.getId() + " не найден, действие отменено."));

        return ShipmentQuality.builder()
                .shipmentId(shipment.getId())
                .qualityCoefficient(request.qualityCoefficient())
                .build();
    }
}
