package com.newtechmat.starbalancer.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy="item", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private Set<Operation> operations;

    @OneToMany(mappedBy="item")
    @JsonManagedReference
    @JsonIgnore
    private Set<WorkTask> workTasks;

    public Item(String name) {
        this.name = name;
    }

    public Item(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Set<WorkTask> getWorkTasks() {
        return workTasks;
    }

    public void setWorkTasks(Set<WorkTask> workTasks) {
        this.workTasks = workTasks;
    }
}
