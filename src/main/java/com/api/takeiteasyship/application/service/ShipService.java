package com.api.takeiteasyship.application.service;

import com.api.takeiteasyship.application.dto.request.ShippingCancelRequestDto;
import com.api.takeiteasyship.application.dto.request.ShippingRequestDto;
import com.api.takeiteasyship.application.dto.response.ShippingDefaultResp;
import com.api.takeiteasyship.domain.entity.Ship;
import com.api.takeiteasyship.domain.repository.ShipRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ShipService {
    private final ShipRepository repository;

    public void register(ShippingRequestDto req) {
        var ship = repository.save(req.toEntity());
        log.info("Ship registered: {}", ship);
    }

    public void cancel(ShippingCancelRequestDto req) {
        repository.findByOrderId(UUID.fromString(req.getOrderId()))
                .ifPresent(repository::delete);
        log.info("Ship canceled: {}", req.getOrderId());
    }
    @CachePut(value = "shippingEntity", key = "#id")
    public ShippingDefaultResp get(String id){
        var ship = repository.findByOrderId(UUID.fromString(id))
                .orElseThrow(()-> new IllegalArgumentException("Ship not found"));

    }




}
