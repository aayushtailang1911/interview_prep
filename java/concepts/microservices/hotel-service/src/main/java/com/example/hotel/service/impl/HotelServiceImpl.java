package com.example.hotel.service.impl;

import com.example.hotel.entity.Hotel;
import com.example.hotel.repository.HotelRepository;
import com.example.hotel.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;

    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hotel create(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return repository.findAll();
    }

    @Override
    public Hotel get(Long id) {
        return repository.findById(id).orElseThrow();
    }
}