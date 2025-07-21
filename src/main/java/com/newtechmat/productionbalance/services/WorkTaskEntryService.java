package com.newtechmat.productionbalance.services;

import com.newtechmat.productionbalance.data.models.WorkTaskEntry;
import com.newtechmat.productionbalance.repositories.WorkTaskEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTaskEntryService {
    private final WorkTaskEntryRepository workTaskEntryRepository;

    public WorkTaskEntryService(WorkTaskEntryRepository workTaskEntryRepository) {
        this.workTaskEntryRepository = workTaskEntryRepository;
    }

    public WorkTaskEntry saveWorkTaskEntry(WorkTaskEntry workTaskEntry) {
        return workTaskEntryRepository.save(workTaskEntry);
    }

    public List<WorkTaskEntry> getByWorkTaskId(Integer workTaskId) {
        return workTaskEntryRepository.getByWorkTaskId(workTaskId);
    }

    public WorkTaskEntry updateWorkTaskEntry(WorkTaskEntry workTaskEntry) {
        return workTaskEntryRepository.save(workTaskEntry);
    }

    public void deleteWorkTaskEntry(Integer id) {
        workTaskEntryRepository.deleteById(id);
    }
}
