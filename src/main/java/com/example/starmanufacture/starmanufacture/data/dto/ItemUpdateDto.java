package com.example.starmanufacture.starmanufacture.data.dto;

public class ItemUpdateDto {
    private Integer id;
    private String name;

    public ItemUpdateDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemUpdateDto(){}

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
}
