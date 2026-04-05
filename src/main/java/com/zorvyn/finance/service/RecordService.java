package com.zorvyn.finance.service;

import com.zorvyn.finance.entity.FinancialRecord;
import com.zorvyn.finance.entity.RecordType;
import com.zorvyn.finance.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final FinancialRecordRepository repo;

    public FinancialRecord create(FinancialRecord record) {
        record.setDate(LocalDate.now());
        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public FinancialRecord update(Long id, FinancialRecord updated) {
        FinancialRecord record = repo.findById(id).orElseThrow();

        record.setAmount(updated.getAmount());
        record.setCategory(updated.getCategory());
        record.setType(updated.getType());
        record.setDescription(updated.getDescription());

        return repo.save(record);
    }

    public String delete(Long id) {
        repo.deleteById(id);
        return "Deleted";
    }


    public List<FinancialRecord> getByCategory(String category) {
        return repo.findByCategoryIgnoreCase(category);
    }

    public List<FinancialRecord> getByType(String type) {
        return repo.findByType(RecordType.valueOf(type.toUpperCase()));
    }

    public List<FinancialRecord> getByDate(LocalDate date) {
        return repo.findByDate(date);
    }
}