package com.example.starmanufacture.starmanufacture.controllers;

import com.example.starmanufacture.starmanufacture.data.models.WorkShift;
import com.example.starmanufacture.starmanufacture.services.ItemService;
import com.example.starmanufacture.starmanufacture.services.WorkShiftService;
import com.example.starmanufacture.starmanufacture.services.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class DataController {

    private final WorkShiftService workShiftService;
    private final WorkerService workerService;
    private final ItemService itemService;

    public DataController(WorkShiftService workShiftService, WorkerService workerService, ItemService itemService) {
        this.workShiftService = workShiftService;
        this.workerService = workerService;
        this.itemService = itemService;
    }

    @GetMapping("")
    String dataIndex(Model model) {
        return "data/data_index";
    }

    @GetMapping("/workers")
    String workersTable(Model model) {
        model.addAttribute("workersList", workerService.getAllWorkers());
        return "data/workers_table";
    }

    @GetMapping("/items")
    String itemsPage(Model model) {
        model.addAttribute("itemsList", itemService.getAllItems());
        return "data/items_table";
    }
}
