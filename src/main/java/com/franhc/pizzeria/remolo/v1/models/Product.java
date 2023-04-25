package com.franhc.pizzeria.remolo.v1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "name", nullable = false, length = 160)
    private String name;

    @Column(name = "description", length = 240)
    private String description;

    @Column(name = "price", nullable = false)
    @Digits(integer = 5, fraction = 2)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    @Digits(integer = 5, fraction = 1)
    private Double stock;

    @ManyToOne
    @JoinColumn(name = "subcategoryId")
    private Subcategory subcategory;

    @OneToMany(mappedBy = "product")
    private Set<DetailOrder> detailOrders;
}
