package com.example.starmanufacture.starmanufacture.repositories;

import com.example.starmanufacture.starmanufacture.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAllByOrderByIdAsc();
}
