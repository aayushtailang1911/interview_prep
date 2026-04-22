package com.example.rating.controller;

import com.example.rating.entity.Rating;
import com.example.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService service;

//    public RatingController(RatingService service) {
//        this.service = service;
//    }

    @PostMapping
    public Rating create(@RequestBody Rating rating) {
        return service.create(rating);
    }

    @GetMapping
    public List<Rating> getAll() {
        return service.getAll();
    }

    @GetMapping("/users/{userId}")
    public List<Rating> getByUser(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    @GetMapping("/hotels/{hotelId}")
    public List<Rating> getByHotel(@PathVariable Long hotelId) {
        return service.getByHotelId(hotelId);
    }
}