package lile_manalu.spring_boot_project.service;

import lile_manalu.spring_boot_project.entity.Food;
import lile_manalu.spring_boot_project.model.CreateFoodRequest;
import lile_manalu.spring_boot_project.model.CreateFoodResponse;
import lile_manalu.spring_boot_project.model.FoodResponse;
import lile_manalu.spring_boot_project.model.UpdateFoodRequest;
import lile_manalu.spring_boot_project.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@Service
public class FoodService {

    private static final Logger logger = LoggerFactory.getLogger(FoodService.class);

    @Autowired
    private FoodRepository foodRepository;

    public CreateFoodResponse create(CreateFoodRequest request){
        logger.debug("Request to create food: {}", request);

        Food food = new Food();
        food.setId(UUID.randomUUID().toString());
        food.setOutlet_id(request.getOutlet_id());
        food.setName(request.getName());
        food.setDescription(request.getDescription());
        food.setPrice(request.getPrice());

        Food savedFood = foodRepository.save(food);
        logger.info("Created new food item: {}", savedFood);

        return toFoodResponse(savedFood);
    }

    public FoodResponse get(String id) {
        logger.debug("Fetching food item with ID: {}", id);

        Food food = foodRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Food item not found with ID: {}", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Food item not found");
                });

        FoodResponse response = toFoodResponse(food);
        logger.debug("Retrieved food item: {}", response);

        return response;
    }

    public FoodResponse update(UpdateFoodRequest request){
        logger.debug("Received update request: {}", request);

        Food food = foodRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Food not found"));

        food.setOutlet_id(request.getOutlet_id());
        food.setName(request.getName());
        food.setDescription(request.getDescription());
        food.setPrice(request.getPrice());
        foodRepository.save(food);

        logger.info("Updated food item: {}", food);

        return toFoodResponse(food);
    }

    public void delete(String foodId) {
        try {
            Food food = foodRepository.findById(foodId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Food not found"));

            foodRepository.delete(food);
            logger.info("Successfully deleted food item with ID: {}", foodId);
        } catch (ResponseStatusException e) {
            logger.error("Error deleting food item with ID: {}. Error: {}", foodId, e.getReason());
            throw e;
        }
    }

    private FoodResponse toFoodResponse(Food food){
        return FoodResponse.builder()
                .id(food.getId())
                .outlet_id(food.getOutlet_id())
                .name(food.getName())
                .description(food.getDescription())
                .price(food.getPrice())
                .build();
    }

}
