package com.newtechmat.productionbalance.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="worktask_entryes")
public class WorkTaskEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worktask_id")
    @JsonBackReference
    private WorkTask workTask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    @JsonBackReference
    private Worker worker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_id")
    @JsonBackReference
    private Operation operation;

    @Column(nullable = false)
    private Integer operationItemsCount;

    public WorkTaskEntry() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WorkTask getWorkTask() {
        return workTask;
    }

    public void setWorkTask(WorkTask workTask) {
        this.workTask = workTask;
    }

    public Integer getOperationItemsCount() {
        return operationItemsCount;
    }

    public void setOperationItemsCount(Integer operationItemsCount) {
        this.operationItemsCount = operationItemsCount;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
