package com.zorvyn.finance.repository;

import com.zorvyn.finance.entity.FinancialRecord;
import com.zorvyn.finance.entity.RecordType;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    @Query("SELECT COALESCE(SUM(f.amount), 0) FROM FinancialRecord f WHERE f.type = :type")
    Double sumByType(@Param("type") RecordType type);

    List<FinancialRecord> findByCategoryIgnoreCase(String category);

    List<FinancialRecord> findByType(RecordType type);

    List<FinancialRecord> findByDate(LocalDate date);

    List<FinancialRecord> findTop5ByOrderByDateDesc();
}