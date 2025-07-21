package com.newtechmat.productionbalance.services;

import com.newtechmat.productionbalance.data.models.Item;
import com.newtechmat.productionbalance.data.models.Operation;
import com.newtechmat.productionbalance.data.models.WorkShiftEntry;
import com.newtechmat.productionbalance.data.models.Worker;
import com.newtechmat.productionbalance.repositories.WorkShiftEntryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WorkShiftEntryService {
    private final WorkShiftEntryRepository workShiftEntryRepository;

    public WorkShiftEntryService(WorkShiftEntryRepository workShiftEntryRepository) {
        this.workShiftEntryRepository = workShiftEntryRepository;
    }

    public Map<Item, Map<Operation, List<WorkShiftEntry>>> getWorkerEntryesGroupByItem(Integer workerId, Integer workshiftId) {
        List<WorkShiftEntry> workShiftEntries =  workShiftEntryRepository.getWorkerEntryes(workerId, workshiftId);
        /*List<CustomItemDto> customItems = new ArrayList<>();
        List<CustomOperationDto> customOperationDto = new ArrayList<>();
        List<CutomEntryDto> cutomEntryDto = new ArrayList<>();
        CustomDto customDto = new CustomDto();
        int itemId = 0;
        int operationId = 0;
        List<CustomOperationDto> customOperations = new ArrayList<>();
        for(WorkShiftEntry e : entryes) {
            if(operationId != e.getOperation().getId()) {
                operationId = e.getOperation().getId();
                customItems.add()
                customOperations = new ArrayList<>();
            }

            cutomEntryDto.add(new CutomEntryDto(e.getWorkTaskNumber(), e.getOperationItemsCount()));
        }*/

        Map<Item, List<WorkShiftEntry>> entriesByItem = workShiftEntries.stream()
                .collect(Collectors.groupingBy(WorkShiftEntry::getItem));

        Map<Item, Map<Operation, List<WorkShiftEntry>>> entriesByItemAndOperation = new HashMap<>();

        entriesByItem.forEach((item, entries) -> {
            Map<Operation, List<WorkShiftEntry>> entriesByOperation = entries.stream().collect(Collectors.groupingBy(WorkShiftEntry::getOperation));
            entriesByItemAndOperation.put(item, entriesByOperation);
        });

        return entriesByItemAndOperation;
    }

    public WorkShiftEntry saveEntry(WorkShiftEntry newWorkShiftEntry) {
        return workShiftEntryRepository.save(newWorkShiftEntry);
    }

    public WorkShiftEntry getEntryById(Integer id) {
        return workShiftEntryRepository.findById(id).get();
    }

    public Map<Worker, List<WorkShiftEntry>> getAllEntryesGroupByWorker(Integer workShiftId) {
        List<WorkShiftEntry> workShiftEntries =  workShiftEntryRepository.findByWorkshiftId(workShiftId);

        return workShiftEntries.stream().collect(Collectors.groupingBy(WorkShiftEntry::getWorker));
    }

    public Map<Operation, List<WorkShiftEntry>> getAllEntryesGroupByOperation(Integer workShiftId) {
        List<WorkShiftEntry> workShiftEntries =  workShiftEntryRepository.findByWorkshiftId(workShiftId);

        return workShiftEntries.stream().collect(Collectors.groupingBy(WorkShiftEntry::getOperation));
    }

    public void deleteEntryById(Integer id) {
        workShiftEntryRepository.deleteById(id);
    }
}
