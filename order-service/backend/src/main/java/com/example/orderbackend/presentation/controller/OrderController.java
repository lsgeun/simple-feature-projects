package com.example.orderbackend.presentation.controller;

import com.example.orderbackend.application.OrderService;
import com.example.orderbackend.presentation.dto.post.OrderRequestDto;
import com.example.orderbackend.presentation.dto.post.OrderResponseDto;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponseDto> readOrder(@PathVariable Long id) {
        OrderResponseDto orderResponseDto = this.orderService.readOrder(id);
        return ResponseEntity.status(200).body(orderResponseDto);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<OrderResponseDto> deleteOrder(@PathVariable Long id) {
        OrderResponseDto orderResponseDto = this.orderService.deleteOrder(id);
        return ResponseEntity.status(200).body(orderResponseDto);
    }

    @PostMapping("/order")
    public ResponseEntity<OrderResponseDto> createOrder(OrderRequestDto orderRequestDto) {
        OrderResponseDto orderResponseDto = this.orderService.createOrder(orderRequestDto);
        return ResponseEntity.status(200).body(orderResponseDto);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable Long id, OrderRequestDto orderRequestDto) {
        OrderResponseDto orderResponseDto = this.orderService.updateOrder(id, orderRequestDto);
        return ResponseEntity.status(200).body(orderResponseDto);
    }
}
