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

    public Worker(String name) {
        this.fullName = name;
    }

    public Worker(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
