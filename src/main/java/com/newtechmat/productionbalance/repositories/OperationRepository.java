package com.newtechmat.productionbalance.repositories;

import com.newtechmat.productionbalance.data.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
}
