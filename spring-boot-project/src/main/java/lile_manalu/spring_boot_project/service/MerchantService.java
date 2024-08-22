package lile_manalu.spring_boot_project.service;

import lile_manalu.spring_boot_project.entity.Merchant;
import lile_manalu.spring_boot_project.model.MerchantResponse;
import lile_manalu.spring_boot_project.repository.MerchantRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MerchantService {

    private static final Logger logger = LoggerFactory.getLogger(MerchantService.class);

    @Autowired
    private MerchantRepository merchantRepository;

    public List<MerchantResponse> list() {
        List<Merchant> merchants = merchantRepository.findAll();
        List<MerchantResponse> merchantResponses = merchants.stream()
                .map(this::toMerchantResponse)
                .collect(Collectors.toList());

        logger.info("Fetched {} merchants", merchantResponses.size());
        return merchantResponses;
    }

    private MerchantResponse toMerchantResponse(Merchant merchant){
        return MerchantResponse.builder()
                .id(merchant.getId())
                .name(merchant.getName())
                .description(merchant.getDescription())
                .build();
    }

}
