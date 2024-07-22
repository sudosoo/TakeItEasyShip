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
    private String description;
    private UUID orderId;
    private List<String> productIds;

    public void shipProduct(List<String> productIds){
        this.productIds = productIds;
    }
}