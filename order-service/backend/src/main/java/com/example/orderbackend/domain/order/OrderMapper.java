package com.example.orderbackend.domain.order;

import com.example.orderbackend.presentation.dto.post.OrderRequestDto;
import com.example.orderbackend.presentation.dto.post.OrderResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    default OrderResponseDto toOrderResponseDto(Order order, String message) {
        Long id = order.getId();
        Long userId = order.getUserId();
        Long productId = order.getProductId();
        Integer quantity = order.getQuantity();
        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .id(id)
                .userId(userId)
                .productId(productId)
                .quantity(quantity)
                .message(message)
                .build();
        return orderResponseDto;
    }

    default Order toOrderSpec(OrderRequestDto orderRequestDto) {
        return new Order(null, orderRequestDto.getUserId(), orderRequestDto.getProductId(), orderRequestDto.getQuantity());
    }
}
