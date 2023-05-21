package com.example.starmanufacture.starmanufacture.models;

import jakarta.persistence.*;

@Entity
@Table(name="workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String fullName;
}
