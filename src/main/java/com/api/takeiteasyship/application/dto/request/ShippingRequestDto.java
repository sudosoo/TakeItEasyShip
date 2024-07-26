package com.api.takeiteasyship.application.dto.request;

import com.api.takeiteasyship.domain.entity.Ship;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ShippingRequestDto {
    private String orderId;
    private String orderOwner;
    private String shippingAddress;
    private String shippingMemo;
    private List<Product> products = new ArrayList<>();

    @Data
    public static class Product {
        private String productId;
        private String productName;
        private int quantity;
    }

    public Ship toEntity() {
        return new Ship(
                UUID.fromString(orderId),
                orderOwner,
                shippingAddress,
                products.stream().map(product -> product.productId).toList());
    }

}



