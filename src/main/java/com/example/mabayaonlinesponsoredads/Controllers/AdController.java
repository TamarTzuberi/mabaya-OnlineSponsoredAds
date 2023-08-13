package com.example.mabayaonlinesponsoredads.Controllers;

import com.example.mabayaonlinesponsoredads.DTOs.CampaignDTO;
import com.example.mabayaonlinesponsoredads.DTOs.PromotedProductDTO;
import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import com.example.mabayaonlinesponsoredads.Services.ProductService;
import com.example.mabayaonlinesponsoredads.Services.ProductsInCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/promotedProduct")
public class AdController {
    private final ProductService productService;
    private final ProductsInCampaignService productsInCampaignService;

    @Autowired
    public AdController(ProductService productService,ProductsInCampaignService productsInCampaignService) {
        this.productService = productService;
        this.productsInCampaignService = productsInCampaignService;
    }

    @GetMapping
    public ResponseEntity<PromotedProductDTO> getPromotedProduct(
            @RequestParam String category) {
        List<Product> categoryProducts = productService.getProductsByCategory(category);
        List<ProductsInCampaign> productsInCampaigns =productsInCampaignService.getProductsInCampaign(categoryProducts);
        return null;
        }


}
