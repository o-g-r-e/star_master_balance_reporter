package com.example.starmanufacture.starmanufacture.models;

import jakarta.persistence.*;

@Entity
@Table(name="operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer workNorm;

    @Column(nullable = false)
    private Double itemsPerMinute;
}
