package lile_manalu.spring_boot_project.controller;

import lile_manalu.spring_boot_project.model.*;
import lile_manalu.spring_boot_project.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
