package com.zorvyn.finance.controller;

import com.zorvyn.finance.service.DashboardService;
import io.swagger.v3.oas.annotations.Operation;
import com.zorvyn.finance.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService service;

    @Operation(summary = "Dashboard Viewer")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    @GetMapping("/summary")
    public ResponseEntity<ApiResponse<?>> summary() {

        Map<String, Object> data = new HashMap<>();

        data.put("totalIncome", service.getTotalIncome());
        data.put("totalExpense", service.getTotalExpense());
        data.put("netBalance", service.getNetBalance());
        data.put("categoryTotals", service.getCategoryTotals());
        data.put("recent", service.getRecent());
        data.put("monthlyTrend", service.getMonthlyTrend());

        return ResponseEntity.ok(
                new ApiResponse<>("success", "Dashboard data", data)
        );
    }
}