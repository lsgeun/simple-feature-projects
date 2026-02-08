package com.example.orderbackend.domain.order;

import lombok.Getter;

@Getter
public class OrderException extends RuntimeException {
    public OrderException(String message) {
        super(message);
    }
}
