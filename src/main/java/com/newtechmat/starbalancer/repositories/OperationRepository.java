package com.newtechmat.starbalancer.repositories;

import com.newtechmat.starbalancer.data.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
}
