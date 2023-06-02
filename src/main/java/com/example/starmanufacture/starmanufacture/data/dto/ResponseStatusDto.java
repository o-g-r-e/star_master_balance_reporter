package com.example.starmanufacture.starmanufacture.data.dto;

public class ResponseStatusDto {
    private Boolean status;

    public ResponseStatusDto(Boolean status) {
        this.status = status;
    }

    public ResponseStatusDto(){}

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
