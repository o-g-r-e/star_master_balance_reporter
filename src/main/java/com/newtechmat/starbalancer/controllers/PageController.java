package com.example.starmanufacture.starmanufacture.controllers;

import com.example.starmanufacture.starmanufacture.data.models.*;
import com.example.starmanufacture.starmanufacture.services.*;
;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    private final WorkerService workerService;
    private final ItemService itemService;
    private final WorkTaskService workTaskService;
    private final WorkShiftService workShiftService;
    private final WorkShiftEntryService workShiftEntryService;

    public PageController(WorkerService workerService, ItemService itemService, WorkTaskService workTaskService, WorkShiftService workShiftService, WorkShiftEntryService workShiftEntryService) {
        this.workerService = workerService;
        this.itemService = itemService;
        this.workTaskService = workTaskService;
        this.workShiftService = workShiftService;
        this.workShiftEntryService = workShiftEntryService;
    }

    @GetMapping("/")
    String homePage(Model model, @CookieValue(name = "workshift_id", required = false) String workshiftId) {
        if (workshiftId != null && !"".equals(workshiftId)) {
            Integer wsId = Integer.valueOf(workshiftId);
            WorkShift currentWorkShift = workShiftService.getWorkShiftById(wsId);
            model.addAttribute("currentWorkShift", currentWorkShift);

            Map<Worker, List<WorkShiftEntry>> workersEntryesMap = workShiftEntryService.getAllEntryesGroupByWorker(wsId);

            model.addAttribute("workersEntryesMap", workersEntryesMap);

            return "workshift";
        }

        return "workshift_creation";
    }

    @GetMapping("/worktasks")
    String worktasksPage(Model model) {
        model.addAttribute("itemsList", itemService.getAllItems());
        model.addAttribute("workTasks", workTaskService.getAllTasks());
        return "worktasks";
    }



    @GetMapping("/worktask/{id}")
    String newtaskPage(@PathVariable Integer id, Model model) {
        WorkTask workTask = workTaskService.getTaskById(id);
        Integer itemsTotal = 0;
        Double timeTotal = 0.0;
        for(WorkTaskEntry wte : workTask.getWorkTaskEntryes()) {
            itemsTotal += wte.getOperationItemsCount();
            timeTotal += Math.ceil(wte.getOperationItemsCount() * wte.getOperation().getItemsPerMinute());
        }
        model.addAttribute("itemsList", itemService.getAllItems());
        model.addAttribute("workTask", workTask);
        model.addAttribute("workersList", workerService.getAllWorkers());
        model.addAttribute("byId", Comparator.comparing(WorkTaskEntry::getId));
        model.addAttribute("itemsTotal", itemsTotal);
        model.addAttribute("timeTotal", timeTotal);
        return "task";
    }

    @GetMapping("/item")
    String itemPage(Model model) {
        return "item";
    }
}
