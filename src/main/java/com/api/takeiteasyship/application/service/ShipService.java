package com.api.takeiteasyship.application.service;

import com.api.takeiteasyship.application.dto.request.ShippingCancelRequestDto;
import com.api.takeiteasyship.application.dto.request.ShippingRequestDto;
import com.api.takeiteasyship.domain.entity.Ship;
import com.api.takeiteasyship.domain.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShipService {
    private final ShipRepository repository;

    public ShipService(ShipRepository repository) {
        this.repository = repository;
    }

    public void register(ShippingRequestDto req) {
        Ship ship = req.toEntity();
        repository.save(ship);
    }

    public void cancel(ShippingCancelRequestDto req) {
        repository.findByOrderId(UUID.fromString(req.getOrderId()))
                .ifPresent(repository::delete);
    }


}
