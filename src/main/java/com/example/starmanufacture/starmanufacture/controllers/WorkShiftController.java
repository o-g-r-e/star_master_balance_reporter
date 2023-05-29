package com.example.starmanufacture.starmanufacture.controllers;

import com.example.starmanufacture.starmanufacture.data.dto.WorkTaskDto;
import com.example.starmanufacture.starmanufacture.data.models.Item;
import com.example.starmanufacture.starmanufacture.data.models.WorkShift;
import com.example.starmanufacture.starmanufacture.data.models.WorkTask;
import com.example.starmanufacture.starmanufacture.services.WorkShiftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkShiftController {

    private final WorkShiftService workShiftService;

    public WorkShiftController(WorkShiftService workShiftService) {
        this.workShiftService = workShiftService;
    }

    @PostMapping(path="/save_workshift")
    @ResponseBody
    ResponseEntity<WorkTask> saveWorkShift(@RequestBody WorkShift workShift) {
        workShiftService.saveWorkShift(workShift);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path="/delete_workshift")
    @ResponseBody
    ResponseEntity<WorkTask> deleteWorkShift(@RequestParam Integer id) {
        workShiftService.deleteWorkShift(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
