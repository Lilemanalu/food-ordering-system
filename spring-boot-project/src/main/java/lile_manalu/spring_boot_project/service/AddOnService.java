package lile_manalu.spring_boot_project.service;

import lile_manalu.spring_boot_project.entity.AddOn;
import lile_manalu.spring_boot_project.entity.Food;
import lile_manalu.spring_boot_project.model.AddOnRequest;
import lile_manalu.spring_boot_project.model.AddOnResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import lile_manalu.spring_boot_project.repository.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@Service
public class AddOnService {

    private static final Logger logger = LoggerFactory.getLogger(AddOnService.class);

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private AddOnRepository addOnRepository;

    public AddOnResponse create(AddOnRequest request) {
        logger.debug("Attempting to create AddOn for Food ID: {}", request.getFood_id());

        Food food = foodRepository.findById(request.getFood_id())
                .orElseThrow(() -> {
                    logger.error("Food not found for ID: {}", request.getFood_id());
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Food is not found");
                });

        AddOn addOn = new AddOn();
        addOn.setId(UUID.randomUUID().toString());
        addOn.setFood_id(request.getFood_id());
        addOn.setName(request.getName());
        addOn.setDescription(request.getDescription());
        addOn.setPrice(request.getPrice());
        addOn.setFood(food);

        addOnRepository.save(addOn);

        logger.info("Successfully created AddOn with ID: {} for Food ID: {}", addOn.getId(), request.getFood_id());

        return toAddOnResponse(addOn);
    }

    private AddOnResponse toAddOnResponse(AddOn addOn) {
        return AddOnResponse.builder()
                .id(addOn.getId())
                .food_id(addOn.getFood_id())
                .name(addOn.getName())
                .description(addOn.getDescription())
                .price(addOn.getPrice())
                .build();
    }


}
