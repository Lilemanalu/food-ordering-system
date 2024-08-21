package lile_manalu.spring_boot_project.service;

import lile_manalu.spring_boot_project.entity.Food;
import lile_manalu.spring_boot_project.model.CreateFoodRequest;
import lile_manalu.spring_boot_project.model.FoodResponse;
import lile_manalu.spring_boot_project.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class FoodService {

    private static final Logger logger = LoggerFactory.getLogger(FoodService.class);

    @Autowired
    private FoodRepository foodRepository;

    public FoodResponse create(CreateFoodRequest request){
        Food food = new Food();
        food.setId(UUID.randomUUID().toString());
        food.setOutlet_id(request.getOutlet_id());
        food.setName(request.getName());
        food.setDescription(request.getDescription());
        food.setPrice(request.getPrice());

        foodRepository.save(food);
        logger.info("Created new food item: {}", food);

        return toFoodResponse(food);
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
