package com.example.rating.service;

import com.example.rating.entity.Rating;
import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getAll();

    List<Rating> getByUserId(Long userId);

    List<Rating> getByHotelId(Long hotelId);
}