package com.newtechmat.starbalancer.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToMany(mappedBy="worker", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<WorkTaskEntry> workTaskEntry;

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
