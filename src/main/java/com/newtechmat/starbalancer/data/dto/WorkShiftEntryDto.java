package com.example.starmanufacture.starmanufacture.data.dto;

public class WorkShiftEntryDto {
    private Integer id;
    private Integer workshiftId;
    private Integer workerId;
    private Integer itemId;
    private Integer operationId;
    private String taskNumber;
    private Integer itemsCount;

    public WorkShiftEntryDto(){}

    public Integer getWorkshiftId() {
        return workshiftId;
    }

    public void setWorkshiftId(Integer workshiftId) {
        this.workshiftId = workshiftId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
