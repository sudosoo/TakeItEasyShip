package com.api.takeiteasyship.application.dto.request;

import com.api.takeiteasyship.domain.entity.Ship;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class ShippingCancelRequestDto {
    private String orderId;
}



