package com.example.mabayaonlinesponsoredads.Controllers;

import com.example.mabayaonlinesponsoredads.DTOs.ProductDTO;
import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import com.example.mabayaonlinesponsoredads.Services.AdService;
import com.example.mabayaonlinesponsoredads.Services.CampaignService;
import com.example.mabayaonlinesponsoredads.Services.ProductService;
import com.example.mabayaonlinesponsoredads.Services.ProductsInCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotedProduct")
public class AdController {
    private final AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public ResponseEntity<ProductDTO> getPromotedProduct(
            @RequestParam String category) {
        ProductDTO productDTO = adService.getPromotedProduct(category);
        if (productDTO != null)
            return ResponseEntity.ok(productDTO);
        return ResponseEntity.noContent().build();
        }



}
