package com.example.orderbackend.presentation.exception;

import com.example.orderbackend.domain.order.Order;
import com.example.orderbackend.domain.order.OrderException;
import com.example.orderbackend.domain.order.OrderRepository;
import com.example.orderbackend.presentation.dto.post.OrderResponseDto;
import org.aspectj.weaver.ast.Or;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDatabaseError(DataAccessException ex) {
        // 로그 남기기
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("DB 처리 중 오류 발생");
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<OrderResponseDto> handleOrderException(
            OrderException ex
    ) {
        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(orderResponseDto);
    }
}
