package com.example.orderbackend.presentation.dto.post;

import lombok.Value;

@Value
public class OrderRequestDto {
    Long userId;
    Long productId;
    Integer quantity;
}
