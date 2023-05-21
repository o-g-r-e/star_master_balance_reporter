package com.example.starmanufacture.starmanufacture.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy="item")
    private Set<Operation> items;
}
