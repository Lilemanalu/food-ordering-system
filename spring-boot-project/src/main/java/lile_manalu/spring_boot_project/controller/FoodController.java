package lile_manalu.spring_boot_project.controller;

import lile_manalu.spring_boot_project.model.CreateFoodRequest;
import lile_manalu.spring_boot_project.model.FoodResponse;
import lile_manalu.spring_boot_project.model.WebResponse;
import lile_manalu.spring_boot_project.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class FoodController {

    private static final Logger logger = LoggerFactory.getLogger(FoodController.class);

    @Autowired
    private FoodService foodService;


    @PostMapping(
            path = "/api/foods",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<FoodResponse> create(@RequestBody CreateFoodRequest request) {
        logger.debug("Received request to create food: {}", request);

        FoodResponse foodResponse;
        try {
            foodResponse = foodService.create(request);
            logger.debug("Food created successfully: {}", foodResponse);
        } catch (Exception e) {
            logger.error("Error creating food", e);
            throw e;
        }

        return WebResponse.<FoodResponse>builder().data(foodResponse).build();
    }


    @GetMapping(
            path = "/api/foods/{foodId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<FoodResponse> get(@PathVariable("foodId") String foodId) {
        logger.debug("Received request to get food item with ID: {}", foodId);

        try {
            FoodResponse foodResponse = foodService.get(foodId);
            logger.debug("Successfully retrieved food item: {}", foodResponse);
            return WebResponse.<FoodResponse>builder().data(foodResponse).build();
        } catch (ResponseStatusException e) {
            logger.error("Error retrieving food item with ID: {}. Error: {}", foodId, e.getMessage());
            throw e;
        }
    }


}
