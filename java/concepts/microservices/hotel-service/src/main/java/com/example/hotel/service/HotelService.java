package com.example.hotel.service;

import com.example.hotel.entity.Hotel;
import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel get(Long id);
}