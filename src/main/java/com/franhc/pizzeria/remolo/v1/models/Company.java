package com.franhc.pizzeria.remolo.v1.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "companies")
public class Company implements Serializable {

    @Id
    @Column(name = "company_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(name = "name", length = 80, nullable = false)
    private String name;

    @Column(name = "description", length = 160)
    private String description;

    @Column(name = "mission", length = 240)
    private String mission;

    @Column(name = "vision", length = 240)
    private String vision;

    @Column(name = "telephone", length = 15, nullable = false)
    private String telephone;

}
