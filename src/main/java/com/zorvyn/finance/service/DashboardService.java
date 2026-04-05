package com.zorvyn.finance.service;

import com.zorvyn.finance.entity.FinancialRecord;
import com.zorvyn.finance.entity.RecordType;
import com.zorvyn.finance.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinancialRecordRepository repo;

    public Double getTotalIncome() {
        Double income = repo.sumByType(RecordType.INCOME);
        return income != null ? income : 0.0;
    }

    public Double getTotalExpense() {
        Double expense = repo.sumByType(RecordType.EXPENSE);
        return expense != null ? expense : 0.0;
    }

    public Double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    public Map<String, Double> getCategoryTotals() {
        return repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        FinancialRecord::getCategory,
                        Collectors.summingDouble(FinancialRecord::getAmount)
                ));
    }

    public List<FinancialRecord> getRecent() {
        return repo.findTop5ByOrderByDateDesc();
    }

    public Map<String, Double> getMonthlyTrend() {
        return repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        r -> r.getDate().getMonth().toString(),
                        Collectors.summingDouble(FinancialRecord::getAmount)
                ));
    }
}