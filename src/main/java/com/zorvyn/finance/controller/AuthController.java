package com.zorvyn.finance.controller;

import com.zorvyn.finance.dto.ApiResponse;
import com.zorvyn.finance.dto.AuthRequest;
import com.zorvyn.finance.entity.User;
import com.zorvyn.finance.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @Operation(summary = "User Register")
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> register(@Valid @RequestBody User user) {

        return ResponseEntity.ok(
                new ApiResponse<>("success", "User registered", service.register(user))
        );
    }

    @Operation(summary = "User Login")
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> login(@Valid @RequestBody AuthRequest req) {

        return ResponseEntity.ok(
                new ApiResponse<>("success", "Login successful", service.login(req))
        );
    }
}