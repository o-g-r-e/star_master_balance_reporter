package com.example.starmanufacture.starmanufacture.repositories;

import com.example.starmanufacture.starmanufacture.data.models.WorkShift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkShiftRepository extends JpaRepository<WorkShift, Integer> {
    WorkShift findFirstByOrderById();
}
