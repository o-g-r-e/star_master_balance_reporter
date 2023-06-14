package com.newtechmat.starbalancer.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    //@JsonBackReference
    private Item item;

    @OneToMany(mappedBy="operation", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<WorkTaskEntry> workTaskEntry;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer workNorm;

    @Column(nullable = false)
    private Double itemsPerMinute;

    public Operation(String name, Integer workNorm, Double itemsPerMinute, Item item) {
        this.name = name;
        this.workNorm = workNorm;
        this.itemsPerMinute = itemsPerMinute;
        this.item = item;
    }
    public Operation(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkNorm() {
        return workNorm;
    }

    public void setWorkNorm(Integer workNorm) {
        this.workNorm = workNorm;
    }

    public Double getItemsPerMinute() {
        return itemsPerMinute;
    }

    public void setItemsPerMinute(Double itemsPerMinute) {
        this.itemsPerMinute = itemsPerMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return id.equals(operation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
