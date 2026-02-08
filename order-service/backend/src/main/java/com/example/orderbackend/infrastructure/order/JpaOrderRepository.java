package com.example.orderbackend.infrastructure.order;


import com.example.orderbackend.domain.order.Order;
import com.example.orderbackend.domain.order.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderRepository extends OrderRepository, JpaRepository<Order, Long> {

}