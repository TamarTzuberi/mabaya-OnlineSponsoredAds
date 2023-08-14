package com.example.mabayaonlinesponsoredads.Controllers;

import com.example.mabayaonlinesponsoredads.DTOs.CampaignDTO;
import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import com.example.mabayaonlinesponsoredads.Services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/newCampaign")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping
    public ResponseEntity<CampaignDTO> createCampaign(
            @RequestBody CampaignDTO campaignDTO) {

        Campaign campaign = campaignService.createCampaign(campaignDTO.getName(),Timestamp.valueOf(campaignDTO.getStartDate()), campaignDTO.getProductIds(), campaignDTO.getBid());
        CampaignDTO createdCampaignDTO = convertCampaignToDTO(campaign);
        return ResponseEntity.ok(createdCampaignDTO);
    }

    // Todo : add mapper class
    private CampaignDTO convertCampaignToDTO(Campaign campaign) {
        CampaignDTO campaignDTO = new CampaignDTO();
        campaignDTO.setName(campaign.getName());
        campaignDTO.setStartDate(String.valueOf(campaign.getStartDate()));
        //convert set of products to list of productIds
        campaignDTO.setProductIds(campaign.getProductsInCampaignSet().stream()
                .map(productsInCampaign -> productsInCampaign.getProduct().getProductId())
                .collect(Collectors.toList()));
        campaignDTO.setBid(campaign.getBid());

        return campaignDTO;
    }

}
