package com.newtechmat.productionbalance.repositories;

import com.newtechmat.productionbalance.data.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    List<Worker> findAllByOrderByIdAsc();
}
