package lile_manalu.spring_boot_project.service;

import lile_manalu.spring_boot_project.entity.*;
import lile_manalu.spring_boot_project.model.*;
import lile_manalu.spring_boot_project.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddOnSnapshotRepository addOnSnapshotRepository;

    @Autowired
    private FoodSnapshotRepository foodSnapshotRepository;

    public OrderResponse create(OrderRequest request) {
        logger.debug("Request to create order: {}", request);

        // Create the Order entity
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setUserId(request.getUserId());
        order.setOutletId(request.getOutletId());
        order.setCreatedTime(new Date());

        // Save the order
        Order savedOrder = orderRepository.save(order);
        logger.info("Created new order: {}", savedOrder);

        List<FoodSnapshotResponse> foodSnapshotResponses = new ArrayList<>();

        // If there are food snapshots, create and save them
        if (request.getFoodSnapshots() != null && !request.getFoodSnapshots().isEmpty()) {
            for (FoodSnapshotResponse foodSnapshotRequest : request.getFoodSnapshots()) { // Changed to FoodSnapshotRequest
                FoodSnapshot foodSnapshot = new FoodSnapshot();
                foodSnapshot.setId(UUID.randomUUID().toString());
                foodSnapshot.setOrderId(savedOrder.getId());
                foodSnapshot.setFoodId(foodSnapshotRequest.getFoodId());
                foodSnapshot.setOutletId(foodSnapshotRequest.getOutletId());
                foodSnapshot.setName(foodSnapshotRequest.getName());
                foodSnapshot.setDescription(foodSnapshotRequest.getDescription());
                foodSnapshot.setPrice(foodSnapshotRequest.getPrice());

                // Save the food snapshot
                FoodSnapshot savedFoodSnapshot = foodSnapshotRepository.save(foodSnapshot);
                logger.info("Created new food snapshot: {}", savedFoodSnapshot);

                List<AddOnSnapshotResponse> addOnSnapshotResponses = new ArrayList<>();

                // If there are add-on snapshots, create and save them
                if (foodSnapshotRequest.getAddOnSnapshots() != null && !foodSnapshotRequest.getAddOnSnapshots().isEmpty()) {
                    for (AddOnSnapshotResponse addOnSnapshotRequest : foodSnapshotRequest.getAddOnSnapshots()) { // Changed to AddOnSnapshotRequest
                        AddOnSnapshot addOnSnapshot = new AddOnSnapshot();
                        addOnSnapshot.setId(UUID.randomUUID().toString());
                        addOnSnapshot.setAddOnId(addOnSnapshotRequest.getAddOnId());
                        addOnSnapshot.setFoodSnapshotId(savedFoodSnapshot.getId());
                        addOnSnapshot.setName(addOnSnapshotRequest.getName());
                        addOnSnapshot.setDescription(addOnSnapshotRequest.getDescription());
                        addOnSnapshot.setPrice(addOnSnapshotRequest.getPrice());

                        // Save the add-on snapshot
                        AddOnSnapshot savedAddOnSnapshot = addOnSnapshotRepository.save(addOnSnapshot);
                        logger.info("Created new add-on snapshot: {}", savedAddOnSnapshot);

                        addOnSnapshotResponses.add(
                                AddOnSnapshotResponse.builder()
                                        .id(savedAddOnSnapshot.getId())
                                        .AddOnId(savedAddOnSnapshot.getAddOnId())
                                        .FoodSnapshotId(savedAddOnSnapshot.getFoodSnapshotId())
                                        .name(savedAddOnSnapshot.getName())
                                        .description(savedAddOnSnapshot.getDescription())
                                        .price(savedAddOnSnapshot.getPrice())
                                        .build()
                        );
                    }
                }

                foodSnapshotResponses.add(
                        FoodSnapshotResponse.builder()
                                .id(savedFoodSnapshot.getId())
                                .orderId(savedFoodSnapshot.getOrderId())
                                .foodId(savedFoodSnapshot.getFoodId())
                                .outletId(savedFoodSnapshot.getOutletId())
                                .name(savedFoodSnapshot.getName())
                                .description(savedFoodSnapshot.getDescription())
                                .price(savedFoodSnapshot.getPrice())
                                .addOnSnapshots(addOnSnapshotResponses)
                                .build()
                );
            }
        }

        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .outletId(order.getOutletId())
                .createdTime(String.valueOf(order.getCreatedTime()))
                .foodSnapshots(foodSnapshotResponses)
                .build();
    }

    public OrderResponse get(String id) {
        logger.debug("Fetching order with ID: {}", id);

        // Retrieve the order
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Order not found with ID: {}", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
                });

        // Retrieve food snapshots associated with the order
        List<FoodSnapshot> foodSnapshots = foodSnapshotRepository.findByOrderId(id);
        List<FoodSnapshotResponse> foodSnapshotResponses = new ArrayList<>();

        for (FoodSnapshot foodSnapshot : foodSnapshots) {
            // Retrieve add-on snapshots for each food snapshot
            List<AddOnSnapshot> addOnSnapshots = addOnSnapshotRepository.findByFoodSnapshotId(foodSnapshot.getId());
            List<AddOnSnapshotResponse> addOnSnapshotResponses = new ArrayList<>();

            for (AddOnSnapshot addOnSnapshot : addOnSnapshots) {
                addOnSnapshotResponses.add(
                        AddOnSnapshotResponse.builder()
                                .id(addOnSnapshot.getId())
                                .AddOnId(addOnSnapshot.getAddOnId())
                                .FoodSnapshotId(addOnSnapshot.getFoodSnapshotId())
                                .name(addOnSnapshot.getName())
                                .description(addOnSnapshot.getDescription())
                                .price(addOnSnapshot.getPrice())
                                .build()
                );
            }

            foodSnapshotResponses.add(
                    FoodSnapshotResponse.builder()
                            .id(foodSnapshot.getId())
                            .orderId(foodSnapshot.getOrderId())
                            .foodId(foodSnapshot.getFoodId())
                            .outletId(foodSnapshot.getOutletId())
                            .name(foodSnapshot.getName())
                            .description(foodSnapshot.getDescription())
                            .price(foodSnapshot.getPrice())
                            .addOnSnapshots(addOnSnapshotResponses)
                            .build()
            );
        }

        // Build and return the order response
        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .outletId(order.getOutletId())
                .createdTime(String.valueOf(order.getCreatedTime()))
                .foodSnapshots(foodSnapshotResponses)
                .build();
    }


    //    //get order by order Id
//    public OrderResponse get(String id) {
//        logger.debug("Fetching order with ID: {}", id);
//
//        Order order = orderRepository.findById(id)
//                .orElseThrow(() -> {
//                    logger.error("Order not found with ID: {}", id);
//                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
//                });
//
//        return OrderResponse.builder()
//                .id(order.getId())
//                .userId(order.getUserId())
//                .outletId(order.getOutletId())
//                .createdTime(String.valueOf(order.getCreatedTime()))
//                .build();
//
//        logger.debug("Retrieved order: {}", order);
//    }

}
