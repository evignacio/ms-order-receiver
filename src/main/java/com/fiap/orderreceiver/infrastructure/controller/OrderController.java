package com.fiap.orderreceiver.infrastructure.controller;

import com.fiap.orderreceiver.core.entity.Order;
import com.fiap.orderreceiver.core.usecase.RegisterOrderRequestUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final RegisterOrderRequestUseCase registerOrderRequestUseCase;

    public OrderController(RegisterOrderRequestUseCase registerOrderRequestUseCase) {
        this.registerOrderRequestUseCase = registerOrderRequestUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> registerRequest(@RequestBody Order order) {
        registerOrderRequestUseCase.execute(order);
        return ResponseEntity.ok()
                .build();
    }
}
