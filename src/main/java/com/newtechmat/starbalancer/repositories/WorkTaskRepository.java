package com.newtechmat.starbalancer.repositories;

import com.newtechmat.starbalancer.data.models.WorkTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTaskRepository extends JpaRepository<WorkTask, Integer> {
}
