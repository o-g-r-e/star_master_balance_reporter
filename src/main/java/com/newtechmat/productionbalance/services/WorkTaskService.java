package com.newtechmat.productionbalance.services;

import com.newtechmat.productionbalance.data.models.WorkTask;
import com.newtechmat.productionbalance.repositories.WorkTaskRepository;
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

    public void deleteWorkTaskById(Integer id) {
        workTaskRepository.deleteById(id);
    }
}
