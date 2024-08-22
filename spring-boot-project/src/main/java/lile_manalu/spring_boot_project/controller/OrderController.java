package lile_manalu.spring_boot_project.controller;

import lile_manalu.spring_boot_project.model.*;
import lile_manalu.spring_boot_project.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping(
            path = "/api/orders",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OrderResponse> create(@RequestBody OrderRequest request) {
        logger.debug("Received request to create order: {}", request);

        OrderResponse orderResponse;
        try {
            orderResponse = orderService.create(request);
            logger.debug("Order created successfully: {}", orderResponse);
        } catch (Exception e) {
            logger.error("Error creating order", e);
            throw e;
        }

        return WebResponse.<OrderResponse>builder().data(orderResponse).build();
    }

    @GetMapping(
            path = "/api/orders/{orderId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OrderResponse> get(@PathVariable("orderId") String orderId) {
        logger.debug("Fetching order with ID: {}", orderId);

        OrderResponse orderResponse;
        try {
            orderResponse = orderService.get(orderId);
            logger.debug("Order retrieved successfully: {}", orderResponse);
        } catch (ResponseStatusException e) {
            logger.error("Error retrieving order with ID: {}", orderId, e);
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error retrieving order with ID: {}", orderId, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error");
        }

        return WebResponse.<OrderResponse>builder().data(orderResponse).build();
    }

}
