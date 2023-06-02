package com.example.starmanufacture.starmanufacture.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "workshifts")
public class WorkShift {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy="workshift", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private Set<WorkShiftEntry> workShiftEntryes;

    public WorkShift(LocalDate date) {
        this.date = date;
    }

    public WorkShift(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
