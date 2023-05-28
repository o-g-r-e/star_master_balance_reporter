package com.example.starmanufacture.starmanufacture.controllers;

import com.example.starmanufacture.starmanufacture.data.models.Worker;
import com.example.starmanufacture.starmanufacture.services.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
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
}
