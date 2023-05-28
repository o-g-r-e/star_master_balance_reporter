package com.example.starmanufacture.starmanufacture.controllers;

import com.example.starmanufacture.starmanufacture.data.models.WorkTask;
import com.example.starmanufacture.starmanufacture.data.models.WorkTaskEntry;
import com.example.starmanufacture.starmanufacture.services.ItemService;
import com.example.starmanufacture.starmanufacture.services.WorkTaskService;
import com.example.starmanufacture.starmanufacture.services.WorkerService;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

@Controller
public class PageController {

    private final WorkerService workerService;
    private final ItemService itemService;
    private final WorkTaskService workTaskService;

    public PageController(WorkerService workerService, ItemService itemService, WorkTaskService workTaskService) {
        this.workerService = workerService;
        this.itemService = itemService;
        this.workTaskService = workTaskService;
    }

    @GetMapping("/")
    String homePage(Model model) {
        return "index";
    }

    @GetMapping("/workers")
    String workersPage(Model model) {
        model.addAttribute("workersList", workerService.getAllWorkers());
        return "workers";
    }

    @GetMapping("/items")
    String itemsPage(Model model) {
        model.addAttribute("itemsList", itemService.getAllItems());
        return "items";
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
