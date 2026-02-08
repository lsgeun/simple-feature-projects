package com.example.orderbackend.application;

import com.example.orderbackend.domain.order.Order;
import com.example.orderbackend.domain.order.OrderException;
import com.example.orderbackend.domain.order.OrderMapper;
import com.example.orderbackend.infrastructure.order.JpaOrderRepository;
import com.example.orderbackend.presentation.dto.post.OrderRequestDto;
import com.example.orderbackend.presentation.dto.post.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final JpaOrderRepository jpaOrderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    OrderService(JpaOrderRepository jpaOrderRepository, OrderMapper orderMapper) {
        this.jpaOrderRepository = jpaOrderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderResponseDto readOrder(Long id) {
        Order order = this.jpaOrderRepository.findById(id).orElse(null);

        if (order == null) {
            throw new OrderException("읽을 데이터가 없음");
        }

        return this.orderMapper.toOrderResponseDto(order, "읽기 성공");
    }

    public OrderResponseDto deleteOrder(Long id) {
        Order order = this.jpaOrderRepository.findById(id).orElse(null);

        if (order == null) {
            throw new OrderException("삭제할 데이터가 없음");
        }

        this.jpaOrderRepository.delete(order);

        return OrderResponseDto.builder()
                .message("삭제 성공")
                .build();
    }

    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order orderSpec = this.orderMapper.toOrderSpec(orderRequestDto);
        this.jpaOrderRepository.save(orderSpec);

        return OrderResponseDto.builder()
                .message("생성 성공")
                .build();
    }

    public OrderResponseDto updateOrder(Long id, OrderRequestDto orderRequestDto) {
        Order order = this.jpaOrderRepository.findById(id).orElse(null);

        if (order == null) {
            throw new OrderException("수정할 데이터가 없음");
        }

        Order orderSpec = this.orderMapper.toOrderSpec(orderRequestDto);
        order.changeSpec(orderSpec);
        this.jpaOrderRepository.save(order);

        return OrderResponseDto.builder()
                .message("수정 성공")
                .build();
    }
}
