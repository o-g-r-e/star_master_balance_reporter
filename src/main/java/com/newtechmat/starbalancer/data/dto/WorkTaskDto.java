package com.newtechmat.starbalancer.data.dto;

import java.time.LocalDate;

public class WorkTaskDto {

    private String number;
    private LocalDate date;
    private Integer itemId;

    public WorkTaskDto(String number, LocalDate date, Integer itemId) {
        this.number = number;
        this.date = date;
        this.itemId = itemId;
    }

    public WorkTaskDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
