package com.example.user.dto;

import lombok.Data;

@Data
public class Hotel {
    private Long id;
    private String name;
    private String location;
    private String about;
}