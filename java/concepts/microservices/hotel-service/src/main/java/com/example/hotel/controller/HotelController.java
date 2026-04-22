package com.example.hotel.controller;

import com.example.hotel.entity.Hotel;
import com.example.hotel.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    @PostMapping
    public Hotel create(@RequestBody Hotel hotel) {
        return service.create(hotel);
    }

    @GetMapping
    public List<Hotel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Hotel get(@PathVariable Long id) {
        return service.get(id);
    }
}