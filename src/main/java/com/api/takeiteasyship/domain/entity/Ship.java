package com.api.takeiteasyship.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Ship {
    @Id
    @Column(updatable = false, nullable = false,columnDefinition = "BINARY(16)")
    private UUID id;
    private String ownerName;
    private String shippingAddress;
    private UUID orderId;

    @ElementCollection
    @CollectionTable(name = "ship_product_ids", joinColumns = @JoinColumn(name = "ship_id"))
    @Column(name = "product_id")
    private List<String> productIds= new ArrayList<>();


    public Ship(UUID orderId, String ownerName, String shippingAddress, List<String> productIds) {
        this.ownerName = ownerName;
        this.shippingAddress = shippingAddress;
        this.orderId = orderId;
        this.productIds.addAll(productIds);
    }
}