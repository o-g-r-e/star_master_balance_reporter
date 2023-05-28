package com.example.starmanufacture.starmanufacture.services;

import com.example.starmanufacture.starmanufacture.data.models.Operation;
import com.example.starmanufacture.starmanufacture.repositories.OperationRepository;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    private final OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public Operation saveOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public Operation updateOperation(Operation requestOperation) {
        Operation operation = operationRepository.findById(requestOperation.getId()).get();
        if(operation != null) {
            operation.setName(requestOperation.getName());
            operation.setWorkNorm(requestOperation.getWorkNorm());
            operation.setItemsPerMinute(requestOperation.getItemsPerMinute());
            return operationRepository.save(operation);
        }

        return null;
    }

    public void removeOperationById(Integer id) {
        operationRepository.deleteById(id);
    }

    public Operation getOperationById(Integer id) {
        return operationRepository.findById(id).get();
    }
}
