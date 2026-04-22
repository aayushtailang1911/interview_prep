package com.example.rating.service.impl;

import com.example.rating.entity.Rating;
import com.example.rating.repository.RatingRepository;
import com.example.rating.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository repository;

    public RatingServiceImpl(RatingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getByHotelId(Long hotelId) {
        return repository.findByHotelId(hotelId);
    }
}