package com.example.orderbackend.domain.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long userId;
    @Column
    private Long productId;
    @Column
    private Integer quantity;

    public void changeSpec(Order order) {
        this.userId = order.userId;
        this.productId = order.productId;
        this.quantity = order.quantity;
    }
}
