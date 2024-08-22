package lile_manalu.spring_boot_project.controller;

import lile_manalu.spring_boot_project.model.MerchantResponse;
import lile_manalu.spring_boot_project.model.WebResponse;
import lile_manalu.spring_boot_project.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class MerchantController {

    private static final Logger logger = LoggerFactory.getLogger(MerchantController.class);

    @Autowired
    private MerchantService merchantService;

    @GetMapping(
            path = "/api/merchants",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<MerchantResponse>> list() {
        logger.debug("Received request to fetch all merchants");

        List<MerchantResponse> merchantResponses = merchantService.list();

        logger.info("Returning {} merchants", merchantResponses.size());
        return WebResponse.<List<MerchantResponse>>builder().data(merchantResponses).build();
    }
}
