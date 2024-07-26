package com.api.takeiteasyship.application.service;

import com.api.takeiteasyship.application.dto.request.ShippingCancelRequestDto;
import com.api.takeiteasyship.application.dto.request.ShippingRequestDto;
import com.api.takeiteasyship.domain.entity.KafkaOperationType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaListenerService {
    private final ShipService shipService;
    private final ObjectMapper objectMapper;

    public KafkaListenerService(ShipService shipService, ObjectMapper objectMapper) {
        this.shipService = shipService;
        this.objectMapper = objectMapper;
    }

    @Transactional
    @KafkaListener(topics = "ORDER", groupId = "ship-group")
    public void orderListener(ConsumerRecord<String, String> record) throws JsonProcessingException {
        KafkaOperationType operationType = KafkaOperationType.valueOf(record.key());
        switch (operationType) {
            case ORDER_COMPLETED:
                ShippingRequestDto request = objectMapper.readValue(record.value(), ShippingRequestDto.class);
                shipService.register(request);
                break;

            case ORDER_CANCELLED:
                ShippingCancelRequestDto req = objectMapper.readValue(record.value(), ShippingCancelRequestDto.class);
                shipService.cancel(req);
                break;
        }

    }
}
