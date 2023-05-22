package com.example.starmanufacture.starmanufacture.controllers;

import com.example.starmanufacture.starmanufacture.dto.SaveStatusResponse;
import com.example.starmanufacture.starmanufacture.models.Worker;
import com.example.starmanufacture.starmanufacture.services.WorkerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@Controller
public class PageController {

    private final WorkerService workerService;
    @Value("${spring.application.name}")
    String appName;

    public PageController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/")
    String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }

    @GetMapping("/workers")
    String workersPage(Model model) {
        model.addAttribute("workersList", workerService.getAllWorkers());
        return "workers";
    }

    @PostMapping(path="/save_worker")
    @ResponseBody
    ResponseEntity<Worker> saveWorker(@RequestBody Worker worker) {
        Worker newWorker = workerService.saveWorker(worker);
        if (newWorker == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(newWorker, HttpStatus.OK);
    }

    @PostMapping(path="/update_worker")
    @ResponseBody
    ResponseEntity<Worker> updateWorker(@RequestBody Worker requestWorker) {
        Worker worker = workerService.updateWorker(requestWorker);
        if (worker == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @PostMapping(path="/remove_worker")
    @ResponseBody
    ResponseEntity<Worker> removeWorker(@RequestParam Integer id) {
        workerService.removeWorkerById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/items")
    String itemsPage(Model model) {
        return "items";
    }

    @GetMapping("/worktasks")
    String worktasksPage(Model model) {
        return "worktasks";
    }

    @GetMapping("/new_task")
    String newtaskPage(Model model) {
        return "new_task";
    }

    @GetMapping("/item")
    String itemPage(Model model) {
        return "new_item";
    }
}
