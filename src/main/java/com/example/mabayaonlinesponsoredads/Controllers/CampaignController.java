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

import java.util.stream.Collectors;

@RestController
@RequestMapping("/newCampaign")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping
    public ResponseEntity<CampaignDTO> createCampaign(
            @RequestBody CampaignDTO campaignDTO) {

        CampaignDTO newCampaignDTO = campaignService.createCampaign(campaignDTO);
        newCampaignDTO.setProductIds(campaignDTO.getProductIds());
        return ResponseEntity.ok(newCampaignDTO);
    }

}
