package com.api.takeiteasyship.application.dto.response;

import com.api.takeiteasyship.domain.entity.Ship;
import lombok.Getter;

@Getter
public class ShippingDefaultResp {
    private String orderId;
    private String ownerName;
    private String shippingAddress;

    public void setOrderId(Ship ship) {

    }
}
