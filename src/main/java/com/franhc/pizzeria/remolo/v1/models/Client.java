package com.franhc.pizzeria.remolo.v1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @Column(name = "client_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "code_number", nullable = false, unique = true)
    @Digits(integer = 10, fraction = 0)
    private Integer codeNumber;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @Email
    @Column(name = "email", length = 80, unique = true)
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Order> order;
}
