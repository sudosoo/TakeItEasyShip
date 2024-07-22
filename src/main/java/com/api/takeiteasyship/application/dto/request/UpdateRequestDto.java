package com.api.takeiteasyship.application.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class UpdateRequestDto {
    private String orderId;
    private String orderOwner;
    private String shippingAddress;
    private String shippingMemo;
    private List<Product> product;

    private static class Product {
        private String productId;
        private String productName;
        private int quantity;
    }

}



