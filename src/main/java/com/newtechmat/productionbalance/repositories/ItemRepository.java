package com.newtechmat.productionbalance.repositories;

import com.newtechmat.productionbalance.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAllByOrderByIdAsc();
}
