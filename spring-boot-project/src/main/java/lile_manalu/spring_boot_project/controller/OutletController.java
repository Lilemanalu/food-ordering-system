package lile_manalu.spring_boot_project.controller;

import lile_manalu.spring_boot_project.model.OutletResponse;
import lile_manalu.spring_boot_project.model.WebResponse;
import lile_manalu.spring_boot_project.service.OutletService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class OutletController {

    private static final Logger logger = LoggerFactory.getLogger(OutletController.class);

    @Autowired
    private OutletService outletService;


    @GetMapping(
            path = "/api/merchants/{merchantId}/outlets",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<OutletResponse>> list(@PathVariable("merchantId") String merchantId) {
        logger.debug("Received request to fetch outlets for merchant ID: {}", merchantId);

        List<OutletResponse> outletResponses;

        try {
            outletResponses = outletService.list(merchantId);
            logger.debug("Successfully fetched outlets for merchant ID: {}", merchantId);
        } catch (Exception e) {
            logger.error("Error fetching outlets for merchant ID: {}", merchantId, e);
            throw e;
        }

        return WebResponse.<List<OutletResponse>>builder().data(outletResponses).build();
    }
}
