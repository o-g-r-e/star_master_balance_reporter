package com.example.starmanufacture.starmanufacture.services;

import com.example.starmanufacture.starmanufacture.data.models.WorkShift;
import com.example.starmanufacture.starmanufacture.repositories.WorkShiftRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkShiftService {
    private final WorkShiftRepository workShiftRepository;


    public WorkShiftService(WorkShiftRepository workShiftRepository) {
        this.workShiftRepository = workShiftRepository;
    }

    public WorkShift getLasOpenWorkShift() {
        return workShiftRepository.getLastOpenWorkshift();
    }

    public WorkShift saveWorkShift(WorkShift workShift) {
        return workShiftRepository.save(workShift);
    }

    public WorkShift getWorkShiftById(Integer id) {
        return workShiftRepository.findById(id).get();
    }
}
