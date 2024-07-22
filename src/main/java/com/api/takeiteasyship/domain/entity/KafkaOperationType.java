package com.api.takeiteasyship.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
public enum KafkaOperationType {
    ORDER_COMPLETED,
    ORDER_CANCELLED,;

}
