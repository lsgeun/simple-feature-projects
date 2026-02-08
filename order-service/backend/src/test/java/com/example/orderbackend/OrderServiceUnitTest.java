package com.example.orderbackend;

import com.example.orderbackend.application.OrderService;
import com.example.orderbackend.domain.order.Order;
import com.example.orderbackend.domain.order.OrderMapper;
import com.example.orderbackend.infrastructure.order.JpaOrderRepository;
import com.example.orderbackend.presentation.dto.post.OrderRequestDto;
import com.example.orderbackend.presentation.dto.post.OrderResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class OrderServiceUnitTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    OrderMapper orderMapper;

    @Mock
    JpaOrderRepository jpaOrderRepository;


    @Test
    void 주문_생성() {
        // given
        OrderRequestDto orderRequestDto = new OrderRequestDto(1L, 1L, 1);
        Order orderSpec = new Order(null, 1L, 1L, 1);
        Order savedOrder = new Order(1L, 1L, 1L, 1);

        when(this.orderMapper.toOrderSpec(orderRequestDto))
                .thenReturn(orderSpec);

        when(this.jpaOrderRepository.save(any(Order.class)))
                .thenReturn(savedOrder);

        // when
        OrderResponseDto orderResponseDto = this.orderService.createOrder(orderRequestDto);

        // then
        assertNotNull(orderResponseDto);
        assertEquals("생성 성공", orderResponseDto.getMessage());
        verify(jpaOrderRepository).save(any(Order.class));
    }
}
