package com.api.takeiteasyship.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ship {
    @Id
    @Column(updatable = false, nullable = false,columnDefinition = "BINARY(16)")
    private UUID id;
    private String ownerName;
    private String shippingAddress;
    private UUID orderId;
    private List<String> productIds;

    public Ship(UUID orderId, String ownerName, String shippingAddress, List<String> productIds) {
        this.ownerName = ownerName;
        this.shippingAddress = shippingAddress;
        this.orderId = orderId;
        this.productIds.addAll(productIds);
    }
}