package lile_manalu.spring_boot_project.controller;

import lile_manalu.spring_boot_project.model.AddOnRequest;
import lile_manalu.spring_boot_project.model.AddOnResponse;
import lile_manalu.spring_boot_project.model.WebResponse;
import lile_manalu.spring_boot_project.service.AddOnService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AddOnController {

    private static final Logger logger = LoggerFactory.getLogger(AddOnController.class);

    @Autowired
    private AddOnService addOnService;

    @PostMapping(
            path = "/api/add-ons",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddOnResponse> create(@RequestBody AddOnRequest request) {
        logger.debug("Received request to create AddOn for Food ID: {}", request.getFood_id());

        AddOnResponse addOnResponse = addOnService.create(request);

        logger.info("Successfully created AddOn with ID: {} for Food ID: {}", addOnResponse.getId(), addOnResponse.getFood_id());
        return WebResponse.<AddOnResponse>builder().data(addOnResponse).build();
    }

}
