package com.example.starmanufacture.starmanufacture.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="worktasks")
public class WorkTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Integer workerId;

    @Column(nullable = false)
    private Integer operationId;

    @Column(nullable = false)
    private Integer taskItems;
}
