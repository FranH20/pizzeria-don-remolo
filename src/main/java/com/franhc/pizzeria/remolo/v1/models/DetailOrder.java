package com.franhc.pizzeria.remolo.v1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "detail_orders")
public class DetailOrder implements Serializable {

    @Id
    @Column(name = "detail_order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailOrderId;

    @Column(name = "amount", nullable = false)
    @Digits(integer = 5, fraction = 1)
    private Double amount;

    @Column(name = "unit_price", nullable = false)
    @Digits(integer = 5, fraction = 2)
    private BigDecimal unitPrice;

    @Column(name = "total_price", nullable = false)
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;
}
