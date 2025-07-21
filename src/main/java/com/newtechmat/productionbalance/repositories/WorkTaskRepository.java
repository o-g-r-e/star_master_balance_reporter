package com.newtechmat.productionbalance.repositories;

import com.newtechmat.productionbalance.data.models.WorkTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTaskRepository extends JpaRepository<WorkTask, Integer> {
}
