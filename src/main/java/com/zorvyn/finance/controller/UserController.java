package com.zorvyn.finance.controller;

import com.zorvyn.finance.dto.ApiResponse;
import com.zorvyn.finance.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @Operation(summary = "View all Users")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getUsers() {
        return ResponseEntity.ok(
                new ApiResponse<>("success", "Users fetched", service.getAllUsers())
        );
    }

    @Operation(summary = "Update User Role")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/role")
    public ResponseEntity<ApiResponse<?>> updateRole(@PathVariable Long id,
                                                     @RequestParam String role) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", "User role updated",
                        service.updateRole(id, role))
        );
    }

    @Operation(summary = "Update User Status")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse<?>> updateStatus(@PathVariable Long id,
                                                       @RequestParam boolean active) {
        return ResponseEntity.ok(
                new ApiResponse<>("success", "User status updated",
                        service.updateStatus(id, active))
        );
    }

    @Operation(summary = "Delete User")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok(
                new ApiResponse<>("success", "User deleted successfully", null)
        );
    }
}