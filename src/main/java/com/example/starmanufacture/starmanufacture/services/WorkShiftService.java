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

    public WorkShift getFirstWorkShift() {
        return workShiftRepository.findFirstByOrderById();
    }

    public void saveWorkShift(WorkShift workShift) {
        workShiftRepository.save(workShift);
    }

    public void deleteWorkShift(Integer id) {
        workShiftRepository.deleteById(id);
    }
}
