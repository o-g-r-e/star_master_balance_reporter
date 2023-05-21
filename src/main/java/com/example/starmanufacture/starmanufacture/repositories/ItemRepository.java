package com.example.starmanufacture.starmanufacture.repositories;

import com.example.starmanufacture.starmanufacture.models.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    List<Item> findByName(String name);
}
