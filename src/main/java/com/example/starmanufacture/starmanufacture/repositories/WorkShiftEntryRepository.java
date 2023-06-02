package com.example.starmanufacture.starmanufacture.repositories;

import com.example.starmanufacture.starmanufacture.data.models.WorkShift;
import com.example.starmanufacture.starmanufacture.data.models.WorkShiftEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkShiftEntryRepository extends JpaRepository<WorkShiftEntry, Integer> {

    @Query(value = """
    SELECT *
    FROM workshifts_entryes
    WHERE worker_id=?1 AND workshift_id=?2
    ORDER BY item_id, operation_id ASC
    """, nativeQuery = true)
    List<WorkShiftEntry> getWorkerEntryes(Integer workerId, Integer workshiftId);

    List<WorkShiftEntry> findByWorkshiftId(Integer workShiftId);
}
