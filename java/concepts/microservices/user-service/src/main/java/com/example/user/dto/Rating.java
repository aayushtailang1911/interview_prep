package com.example.user.dto;

import lombok.Data;

@Data
public class Rating {

    private Long id;
    private String userId;
    private String hotelId;
    private int rating;

    private Hotel hotel;
}