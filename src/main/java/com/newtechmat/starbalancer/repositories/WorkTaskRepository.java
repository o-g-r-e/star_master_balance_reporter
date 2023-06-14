package com.example.starmanufacture.starmanufacture.repositories;

import com.example.starmanufacture.starmanufacture.data.models.WorkTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTaskRepository extends JpaRepository<WorkTask, Integer> {
}
