package lile_manalu.spring_boot_project.service;

import lile_manalu.spring_boot_project.entity.Outlet;
import lile_manalu.spring_boot_project.model.OutletResponse;
import lile_manalu.spring_boot_project.repository.OutletRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OutletService {

    private static final Logger logger = LoggerFactory.getLogger(OutletService.class);

    @Autowired
    private OutletRepository outletRepository;

    // Service method to get all outlets for a specific merchant
    public List<OutletResponse> list(String merchantId) {
        logger.debug("Fetching outlets for merchant ID: {}", merchantId);

        List<Outlet> outlets = outletRepository.findByMerchantId(merchantId);

        if (outlets.isEmpty()) {
            logger.error("No outlets found for merchant ID: {}", merchantId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No outlets found for this merchant");
        }

        // Convert the list of Outlet entities to OutletResponse DTOs
        List<OutletResponse> outletResponses = outlets.stream()
                .map(this::toOutletResponse)
                .collect(Collectors.toList());

        logger.info("Fetched {} outlets for Merchant ID: {}", outletResponses.size(), merchantId);
        return outletResponses;
    }

    private OutletResponse toOutletResponse(Outlet outlet){
        return OutletResponse.builder()
                .id(outlet.getId())
                .merchantId(outlet.getMerchantId())
                .name(outlet.getName())
                .description(outlet.getDescription())
                .build();
    }
}
