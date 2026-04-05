package com.zorvyn.finance.controller;

import com.zorvyn.finance.dto.ApiResponse;
import com.zorvyn.finance.entity.FinancialRecord;
import com.zorvyn.finance.entity.RecordType;
import com.zorvyn.finance.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService service;

    @Operation(summary = "Create Financial Record")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<?>> create(@Valid @RequestBody FinancialRecord record) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", "Record created", service.create(record))
        );
    }

    @Operation(summary = "Get all Financial Records")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAll() {
        return ResponseEntity.ok(
                new ApiResponse<>("success", "Records fetched", service.getAll())
        );
    }

    @Operation(summary = "Update Financial Record")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> update(@PathVariable Long id,
                                                 @Valid @RequestBody FinancialRecord record) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", "Record updated", service.update(id, record))
        );
    }

    @Operation(summary = "Delete Financial Record")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(
                new ApiResponse<>("success", "Record deleted", null)
        );
    }

    @Operation(summary = "Get Records by Category (case-insensitive)")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/category")
    public ResponseEntity<ApiResponse<?>> getByCategory(@RequestParam String category) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", "Filtered records",
                        service.getByCategory(category))
        );
    }

    @Operation(summary = "Get Records by Type")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/type")
    public ResponseEntity<ApiResponse<?>> getByType(@RequestParam RecordType type) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", "Filtered by type",
                        service.getByType(type.name()))
        );
    }

    @Operation(summary = "Get Records by Date")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/date")
    public ResponseEntity<ApiResponse<?>> getByDate(@RequestParam LocalDate date) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", "Filtered by date",
                        service.getByDate(date))
        );
    }
}