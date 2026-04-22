package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.exception.ResourceNotFoundException;
import com.example.user.external.HotelClient;
import com.example.user.external.RatingClient;
import com.example.user.dto.*;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RatingClient ratingClient;
    private final HotelClient hotelClient;

    public UserService(UserRepository userRepository,
                       RatingClient ratingClient,
                       HotelClient hotelClient) {
        this.userRepository = userRepository;
        this.ratingClient = ratingClient;
        this.hotelClient = hotelClient;
    }

    public UserResponse getUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for id : "+userId));

        List<Rating> ratings = null;
        try {
            // Step 1: fetch ratings
            ratings = ratingClient.getRatings(userId);

            // Step 2: attach hotel data
            ratings.forEach(r -> {
                try {
                    Hotel hotel = hotelClient.getHotel(r.getHotelId());
                    r.setHotel(hotel);
                }catch (RuntimeException runtimeException){
                    throw new RuntimeException("no hotels found with HotelId: "+userId);
                }
            });
        }catch (Exception e){
            throw new ResourceNotFoundException("rating not found for user with id : " + userId);
        }


        // Step 3: build response
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRatings(ratings);

        return response;
    }
}