package com.newtechmat.starbalancer.repositories;

import com.newtechmat.starbalancer.data.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    List<Worker> findAllByOrderByIdAsc();
}
