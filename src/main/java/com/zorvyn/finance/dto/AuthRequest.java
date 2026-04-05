package com.zorvyn.finance.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}