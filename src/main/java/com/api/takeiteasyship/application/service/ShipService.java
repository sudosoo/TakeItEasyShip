package com.api.takeiteasyship.application.service;

import com.api.takeiteasyship.domain.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipService {
    private final ShipRepository shipRepository;

    public void updateShip() {

    }

    public void syncProductInfo() {

    }

    //TODO 상품 업데이트 (생성,수정) 동기화 해주는 메소드 추가

}
