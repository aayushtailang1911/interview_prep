package com.example.user.external;

import com.example.user.dto.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "rating-service")
public interface RatingClient {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatings(@PathVariable Long userId);
}