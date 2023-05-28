package com.example.starmanufacture.starmanufacture.controllers;

import com.example.starmanufacture.starmanufacture.data.dto.WorkTaskDto;
import com.example.starmanufacture.starmanufacture.data.dto.WorkTaskEntryDto;
import com.example.starmanufacture.starmanufacture.data.models.*;
import com.example.starmanufacture.starmanufacture.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;

@Controller
public class WorkTaskController {

    private final WorkTaskService workTaskService;
    private final WorkTaskEntryService workTaskEntryService;
    private final ItemService itemService;

    private final WorkerService workerService;

    private final OperationService operationService;

    public WorkTaskController(WorkTaskService workTaskService, WorkTaskEntryService workTaskEntryService, ItemService itemService, WorkerService workerService, OperationService operationService) {
        this.workTaskService = workTaskService;
        this.workTaskEntryService = workTaskEntryService;
        this.itemService = itemService;
        this.workerService = workerService;
        this.operationService = operationService;
    }

    @PostMapping(path="/save_worktask")
    @ResponseBody
    ResponseEntity<WorkTask> saveWorktask(@RequestBody WorkTaskDto worktaskDto) {
        Item workTaskItem = itemService.getItemById(worktaskDto.getItemId());

        WorkTask newWorkTask = new WorkTask();
        newWorkTask.setNumber(worktaskDto.getNumber());
        newWorkTask.setDate(worktaskDto.getDate());
        newWorkTask.setItem(workTaskItem);

        WorkTask savedWorkTask = workTaskService.saveWorktask(newWorkTask);

        return new ResponseEntity<>(savedWorkTask, HttpStatus.OK);
    }

    @PostMapping(path="/update_worktask")
    @ResponseBody
    ResponseEntity<WorkTask> updateWorktask(@RequestBody WorkTask requestWorktask) {

        WorkTask workTask = workTaskService.getTaskById(requestWorktask.getId());
        workTask.setNumber(requestWorktask.getNumber());
        workTask.setDate(requestWorktask.getDate());

        WorkTask savedWorkTask = workTaskService.saveWorktask(workTask);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private WorkTaskEntry fromDto(WorkTaskEntryDto workTaskEntryDto) {
        WorkTask workTask = workTaskService.getTaskById(workTaskEntryDto.getWorkTaskId());
        Worker worker = workerService.getWorkerById(workTaskEntryDto.getWorkerId());
        Operation operation = operationService.getOperationById(workTaskEntryDto.getOperationId());

        WorkTaskEntry workTaskEntry = new WorkTaskEntry();
        workTaskEntry.setId(workTaskEntryDto.getId());
        workTaskEntry.setWorkTask(workTask);
        workTaskEntry.setOperation(operation);
        workTaskEntry.setWorker(worker);
        workTaskEntry.setOperationItemsCount(workTaskEntryDto.getOperationItemsCount());

        return workTaskEntry;
    }

    @PostMapping(path="/save_worktask_entry")
    @ResponseBody
    ResponseEntity<WorkTaskEntry> saveWorkTaskEntry(@RequestBody WorkTaskEntryDto workTaskEntryDto) {
        WorkTaskEntry workTaskEntry = fromDto(workTaskEntryDto);

        WorkTaskEntry savedWorkTaskEntry = workTaskEntryService.saveWorkTaskEntry(workTaskEntry);

        return new ResponseEntity<>(savedWorkTaskEntry, HttpStatus.OK);
    }

    @PostMapping(path="/update_worktask_entry")
    @ResponseBody
    ResponseEntity<WorkTaskEntry> updateWorkTaskEntry(@RequestBody WorkTaskEntryDto workTaskEntryDto) {
        WorkTaskEntry workTaskEntry = fromDto(workTaskEntryDto);

        WorkTaskEntry updatedWorkTaskEntry = workTaskEntryService.updateWorkTaskEntry(workTaskEntry);

        return new ResponseEntity<>(updatedWorkTaskEntry, HttpStatus.OK);
    }

    @PostMapping(path="/delete_worktask_entry")
    @ResponseBody
    ResponseEntity<WorkTaskEntry> deleteWorkTaskEntry(@RequestParam Integer id) {
        workTaskEntryService.deleteWorkTaskEntry(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path="/delete_worktask")
    @ResponseBody
    ResponseEntity<WorkTaskEntry> deleteWorkTask(@RequestParam Integer id) {
        workTaskService.deleteWorkTaskById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
