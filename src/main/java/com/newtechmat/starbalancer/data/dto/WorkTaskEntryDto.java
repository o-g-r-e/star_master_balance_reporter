package com.example.starmanufacture.starmanufacture.data.dto;

public class WorkTaskEntryDto {
    private Integer id;
    private Integer workTaskId;
    private Integer operationId;
    private Integer WorkerId;
    private Integer operationItemsCount;

    public WorkTaskEntryDto(Integer workTaskId, Integer workerId, Integer operationItemsCount) {
        this.workTaskId = workTaskId;
        WorkerId = workerId;
        this.operationItemsCount = operationItemsCount;
    }

    public WorkTaskEntryDto(){}

    public Integer getWorkTaskId() {
        return workTaskId;
    }

    public void setWorkTaskId(Integer workTaskId) {
        this.workTaskId = workTaskId;
    }

    public Integer getWorkerId() {
        return WorkerId;
    }

    public void setWorkerId(Integer workerId) {
        WorkerId = workerId;
    }

    public Integer getOperationItemsCount() {
        return operationItemsCount;
    }

    public void setOperationItemsCount(Integer operationItemsCount) {
        this.operationItemsCount = operationItemsCount;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
