package com.newtechmat.starbalancer.services;

import com.newtechmat.starbalancer.data.models.Worker;
import com.newtechmat.starbalancer.repositories.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker saveWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker updateWorker(Worker requestWorker) {
        Worker worker = workerRepository.findById(requestWorker.getId()).get();
        if(worker != null) {
            worker.setFullName(requestWorker.getFullName());
            return workerRepository.save(worker);
        }

        return null;
    }

    public void removeWorkerById(Integer id) {
        workerRepository.deleteById(id);
    }

    public List<Worker> getAllWorkers() {
        return workerRepository.findAllByOrderByIdAsc();
    }

    public Worker getWorkerById(Integer id) {
        return workerRepository.findById(id).get();
    }
}
