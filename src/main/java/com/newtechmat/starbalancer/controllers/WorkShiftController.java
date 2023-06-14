package com.newtechmat.starbalancer.controllers;

import com.newtechmat.starbalancer.data.dto.WorkShiftEntryDto;
import com.newtechmat.starbalancer.data.models.*;
import com.newtechmat.starbalancer.services.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/workshifts")
public class WorkShiftController {

    private final WorkShiftService workShiftService;
    private final WorkerService workerService;
    private final WorkShiftEntryService workShiftEntryService;
    private final ItemService itemService;
    private final OperationService operationService;

    public WorkShiftController(WorkShiftService workShiftService, WorkerService workerService, WorkShiftEntryService workShiftEntryService, ItemService itemService, OperationService operationService) {
        this.workShiftService = workShiftService;
        this.workerService = workerService;
        this.workShiftEntryService = workShiftEntryService;
        this.itemService = itemService;
        this.operationService = operationService;
    }

    @GetMapping(path="/{workShiftId}")
    String saveWorkShift(@PathVariable Integer workShiftId, Model model) {
        WorkShift workShift = workShiftService.getWorkShiftById(workShiftId);
        model.addAttribute("currentWorkShift", workShift);
        return "workshift";
    }

    @GetMapping(path="/select_worker")
    String selectWorker(@CookieValue(name = "workshift_id", required = false) String workshiftId, Model model) {

        if (workshiftId == null || "".equals(workshiftId)) {
            return "workshift_notfound";
        }

        /*Integer wsId = Integer.valueOf(workshiftId);
        WorkShift currentWorkShift = workShiftService.getWorkShiftById(wsId);
        model.addAttribute("currentWorkShift", currentWorkShift);*/
        model.addAttribute("workersList", workerService.getAllWorkers());
        return "worker_selection";
    }

    @GetMapping("/{workShiftId}/workers/{workerId}/add_operation/{operationId}")
    String addOperation(@PathVariable Integer workShiftId, @PathVariable Integer workerId, @PathVariable Integer operationId,Model model) {
        WorkShift currentWorkShift = workShiftService.getWorkShiftById(workShiftId);
        Worker currentWorker = workerService.getWorkerById(workerId);
        Operation operation = operationService.getOperationById(operationId);

        WorkShiftEntry newWorkShiftEntry = new WorkShiftEntry();
        newWorkShiftEntry.setWorkshift(currentWorkShift);
        newWorkShiftEntry.setWorker(currentWorker);
        newWorkShiftEntry.setOperation(operation);

        workShiftEntryService.saveEntry(newWorkShiftEntry);

        return "redirect:/workshifts/"+workShiftId+"/workers/"+workerId+"/workpage";
    }

    @PostMapping(path="/save")
    @ResponseBody
    ResponseEntity<WorkShift> saveWorkShift(@RequestBody WorkShift workShift, HttpServletResponse response) {
        WorkShift newWorkShift = workShiftService.saveWorkShift(workShift);

        Cookie cookie = new Cookie("workshift_id", String.valueOf(newWorkShift.getId()));
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ResponseEntity<>(newWorkShift, HttpStatus.OK);
    }

    @PostMapping(path="/close")
    ResponseEntity<WorkShift> closeWorkShift(HttpServletResponse response) {

        Cookie cookie = new Cookie("workshift_id", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
