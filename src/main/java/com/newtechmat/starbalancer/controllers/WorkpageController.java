package com.example.starmanufacture.starmanufacture.controllers;

import com.example.starmanufacture.starmanufacture.data.dto.ResponseStatusDto;
import com.example.starmanufacture.starmanufacture.data.dto.WorkShiftEntryDto;
import com.example.starmanufacture.starmanufacture.data.models.*;
import com.example.starmanufacture.starmanufacture.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/workpage")
public class WorkpageController {
    private final WorkerService workerService;
    private final WorkShiftEntryService workShiftEntryService;
    private final WorkShiftService workShiftService;
    private final ItemService itemService;
    private final OperationService operationService;

    public WorkpageController(WorkerService workerService, WorkShiftEntryService workShiftEntryService, WorkShiftService workShiftService, ItemService itemService, OperationService operationService) {
        this.workerService = workerService;
        this.workShiftEntryService = workShiftEntryService;
        this.workShiftService = workShiftService;
        this.itemService = itemService;
        this.operationService = operationService;
    }

    @GetMapping("/worker/{workerId}")
    String workPage(@CookieValue(name = "workshift_id", required = false) String workshiftId, @PathVariable Integer workerId, Model model) {

        if (workshiftId == null || "".equals(workshiftId)) {
            return "workshift_notfound";
        }

        Integer wsId = Integer.valueOf(workshiftId);

        model.addAttribute("worker", workerService.getWorkerById(workerId));
        Map<Item, Map<Operation, List<WorkShiftEntry>>> workerEntryes = workShiftEntryService.getWorkerEntryesGroupByItem(workerId, wsId);
        model.addAttribute("workerEntryes", workerEntryes);
        return "workpage";
    }

    @PostMapping("/add_entry")
    @ResponseBody
    ResponseEntity<WorkShiftEntry> addEntry(@CookieValue(name = "workshift_id", required = false) String workshiftId, @RequestBody WorkShiftEntryDto workShiftEntryDto, Model model) {
        Integer wsId = Integer.valueOf(workshiftId);
        WorkShift ws = workShiftService.getWorkShiftById(wsId);

        Worker worker = workerService.getWorkerById(workShiftEntryDto.getWorkerId());
        Item item = itemService.getItemById(workShiftEntryDto.getItemId());
        Operation operation = operationService.getOperationById(workShiftEntryDto.getOperationId());

        WorkShiftEntry workShiftEntry = new WorkShiftEntry();
        workShiftEntry.setWorkshift(ws);
        workShiftEntry.setWorker(worker);
        workShiftEntry.setItem(item);
        workShiftEntry.setOperation(operation);
        workShiftEntry.setWorkTaskNumber(workShiftEntryDto.getTaskNumber());
        workShiftEntry.setOperationItemsCount(workShiftEntryDto.getItemsCount());

        WorkShiftEntry savedWorkShiftEntry = workShiftEntryService.saveEntry(workShiftEntry);

        return new ResponseEntity<>(savedWorkShiftEntry, HttpStatus.OK);
    }

    @PostMapping("/save_entry")
    @ResponseBody
    ResponseEntity<WorkShiftEntry> saveEntry(@RequestBody WorkShiftEntryDto workShiftEntryDto, Model model) {
        WorkShiftEntry workShiftEntry = workShiftEntryService.getEntryById(workShiftEntryDto.getId());
        workShiftEntry.setWorkTaskNumber(workShiftEntryDto.getTaskNumber());
        workShiftEntry.setOperationItemsCount(workShiftEntryDto.getItemsCount());

        WorkShiftEntry savedWorkShiftEntry = workShiftEntryService.saveEntry(workShiftEntry);

        return new ResponseEntity<>(savedWorkShiftEntry, HttpStatus.OK);
    }

    @PostMapping("/delete_entry")
    @ResponseStatus
    ResponseEntity<ResponseStatusDto> deleteEntry(@RequestBody WorkShiftEntryDto workShiftEntryDto) {

        workShiftEntryService.deleteEntryById(workShiftEntryDto.getId());

        return new ResponseEntity<>(new ResponseStatusDto(true), HttpStatus.OK);
    }

    @GetMapping("/worker/{workerId}/select_operation")
    String selectOperationPage(@PathVariable Integer workerId, Model model) {
        model.addAttribute("worker", workerService.getWorkerById(workerId));
        model.addAttribute("itemsList", itemService.getAllItems());
        return "select_operation";
    }
}
