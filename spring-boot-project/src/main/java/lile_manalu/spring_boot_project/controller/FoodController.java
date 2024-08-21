package lile_manalu.spring_boot_project.controller;

import lile_manalu.spring_boot_project.model.*;
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
    public WebResponse<CreateFoodResponse> create(@RequestBody CreateFoodRequest request) {
        logger.debug("Received request to create food: {}", request);

        CreateFoodResponse createFoodResponse;
        try {
            createFoodResponse = foodService.create(request);
            logger.debug("Food created successfully: {}", createFoodResponse);
        } catch (Exception e) {
            logger.error("Error creating food", e);
            throw e;
        }

        return WebResponse.<CreateFoodResponse>builder().data(createFoodResponse).build();
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

    @PutMapping(
            path = "/api/foods/{foodId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<FoodResponse> update(@RequestBody UpdateFoodRequest request,
                                            @PathVariable String foodId) {
        logger.debug("Received request to update food item with ID: {} and data: {}", foodId, request);

        request.setId(foodId);
        FoodResponse foodResponse;
        try {
            foodResponse = foodService.update(request);

            logger.debug("Successfully updated food item with ID: {}. Response data: {}", foodId, foodResponse);
        } catch (Exception e) {
            logger.error("Error updating food item with ID: {}. Error: {}", foodId, e.getMessage());
            throw e;
        }

        return WebResponse.<FoodResponse>builder().data(foodResponse).build();
    }

}
