package com.example.user.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private boolean success;
    private int status;
    private LocalDateTime timestamp;
}
