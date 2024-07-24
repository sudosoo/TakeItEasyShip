package com.api.takeiteasyship.domain.repository;

import com.api.takeiteasyship.domain.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShipRepository extends JpaRepository<Ship, UUID> {
    Optional<Ship> findByOrderId(UUID orderId);

}