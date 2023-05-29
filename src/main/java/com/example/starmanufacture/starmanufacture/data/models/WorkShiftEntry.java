package com.example.starmanufacture.starmanufacture.data.models;

import jakarta.persistence.*;

@Entity
@Table(name = "workshifts_entryes")
public class WorkShiftEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "workshift_id")
    private WorkShift workshift;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Column(nullable = false)
    private String workTaskNumber;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @Column(nullable = false)
    private Integer operationItemsCount;

    public WorkShiftEntry(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getWorkTaskNumber() {
        return workTaskNumber;
    }

    public void setWorkTaskNumber(String workTaskNumber) {
        this.workTaskNumber = workTaskNumber;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Integer getOperationItemsCount() {
        return operationItemsCount;
    }

    public void setOperationItemsCount(Integer operationItemsCount) {
        this.operationItemsCount = operationItemsCount;
    }

    public WorkShift getWorkshift() {
        return workshift;
    }

    public void setWorkshift(WorkShift workshift) {
        this.workshift = workshift;
    }
}
