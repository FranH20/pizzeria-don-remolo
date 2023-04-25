package com.franhc.pizzeria.remolo.v1.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "subcategories")
public class Subcategory implements Serializable {

    @Id
    @Column(name = "subcategory_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcategoryId;

    @Column(name = "name", nullable = false, length = 160)
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "subcategory")
    private List<Product> products;
}
