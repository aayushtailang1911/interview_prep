package com.example.user.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String email;

    private List<Rating> ratings;
}