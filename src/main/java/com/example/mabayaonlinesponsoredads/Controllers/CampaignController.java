package com.example.mabayaonlinesponsoredads.Controllers;
import com.example.mabayaonlinesponsoredads.DTOs.CampaignDTO;
import com.example.mabayaonlinesponsoredads.Services.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newCampaign")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;
    private static final Logger logger = LoggerFactory.getLogger(AdController.class);

    @PostMapping
    public ResponseEntity<CampaignDTO> createCampaign(
            @RequestBody CampaignDTO campaignDTO) {
        try {
            CampaignDTO newCampaignDTO = campaignService.createCampaign(campaignDTO);
            return ResponseEntity.ok(newCampaignDTO);
        } catch (Exception e) {
            logger.error("An error occurred " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CampaignDTO());
        }
    }

}
