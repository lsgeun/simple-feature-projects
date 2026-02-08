package com.example.orderbackend.presentation.dto.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class OrderResponseDto {
    private final Long id;
    private final Long userId;
    private final Long productId;
    private final Integer quantity;

    private final String message;
}
