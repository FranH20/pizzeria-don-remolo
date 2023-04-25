package com.franhc.pizzeria.remolo.v1.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Valid
    @OneToMany(mappedBy = "category")
    private List<Subcategory> subcategories;

    public List<Subcategory> getSubcategories() {
        return CollectionUtils.isEmpty(this.subcategories) ? Collections.emptyList() : this.subcategories;
    }
}
