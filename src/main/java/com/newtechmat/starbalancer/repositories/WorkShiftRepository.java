package com.newtechmat.starbalancer.repositories;

import com.newtechmat.starbalancer.data.models.WorkShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkShiftRepository extends JpaRepository<WorkShift, Integer> {
    @Query(value = """
    SELECT *
    FROM workshifts
    WHERE status='open'
    ORDER BY id DESC
    LIMIT 1
    """, nativeQuery = true)
    WorkShift getLastOpenWorkshift();
}
