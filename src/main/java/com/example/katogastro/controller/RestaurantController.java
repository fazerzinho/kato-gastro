package com.example.katogastro.controller;

import com.example.katogastro.entity.Restaurant;
import com.example.katogastro.exception.ResourceNotFoundException;
import com.example.katogastro.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;
    //get Restaurants
    @GetMapping("restaurants")
    public List<Restaurant> getAllRestaurants(){
        return this.restaurantRepository.findAll();
    }
    //get Restaurant
    @GetMapping("restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable(value = "id") Long restaurantId)
            throws ResourceNotFoundException {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()-> new ResourceNotFoundException("restaurant not found :: " + restaurantId));
        return ResponseEntity.ok().body(restaurant);
    }
    //save Restaurant
    @PostMapping("restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return this.restaurantRepository.save(restaurant);
    }
    //update Restaurant
    @PutMapping("restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") Long restaurantId, @Valid @RequestBody Restaurant restaurantDetails)
        throws ResourceNotFoundException {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()-> new ResourceNotFoundException("restaurant not found :: " + restaurantId));
        restaurant.setAddress(restaurantDetails.getAddress());
        restaurant.setCuisine(restaurantDetails.getCuisine());
        restaurant.setDegrees(restaurantDetails.getDegrees());
        restaurant.setMinutes(restaurantDetails.getMinutes());
        restaurant.setName(restaurantDetails.getName());
        restaurant.setVisited(restaurantDetails.isVisited());
        return ResponseEntity.ok(this.restaurantRepository.save(restaurant));
    }
    //delete Restaurant
    @DeleteMapping("restaurants/{id}")
    public Map<String, Boolean> deleteRestaurant(@PathVariable(value = "id") Long restaurantId)
        throws ResourceNotFoundException{
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()-> new ResourceNotFoundException("restaurant not found :: " + restaurantId));
        this.restaurantRepository.deleteById(restaurantId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
