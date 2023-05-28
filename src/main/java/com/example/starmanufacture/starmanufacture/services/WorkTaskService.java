package com.example.starmanufacture.starmanufacture.services;

import com.example.starmanufacture.starmanufacture.data.models.WorkTask;
import com.example.starmanufacture.starmanufacture.repositories.WorkTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTaskService {
    private final WorkTaskRepository workTaskRepository;

    public WorkTaskService(WorkTaskRepository workTaskRepository) {
        this.workTaskRepository = workTaskRepository;
    }

    public List<WorkTask> getAllTasks() {
        return workTaskRepository.findAll();
    }

    public WorkTask saveWorktask(WorkTask worktask) {
        return workTaskRepository.save(worktask);
    }

    public WorkTask getTaskById(Integer id) {
        return workTaskRepository.findById(id).get();
    }
}
