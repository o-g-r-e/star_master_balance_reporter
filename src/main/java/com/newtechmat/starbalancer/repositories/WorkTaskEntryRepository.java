package com.example.starmanufacture.starmanufacture.repositories;

import com.example.starmanufacture.starmanufacture.data.models.WorkTaskEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkTaskEntryRepository extends JpaRepository<WorkTaskEntry, Integer> {

    @Query(value = """
    SELECT *
    FROM worktask_entryes
    WHERE worktask_id = ?1
    """, nativeQuery = true)
    List<WorkTaskEntry> getByWorkTaskId(Integer workTaskId);
}
