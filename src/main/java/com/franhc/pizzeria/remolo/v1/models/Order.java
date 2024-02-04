package com.franhc.pizzeria.remolo.v1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_amount", nullable = false)
    @Digits(integer = 9, fraction = 2)
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order")
    private Set<DetailOrder> detailOrders;
}
