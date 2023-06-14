package com.example.starmanufacture.starmanufacture.repositories;

import com.example.starmanufacture.starmanufacture.data.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
}
