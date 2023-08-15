package com.example.mabayaonlinesponsoredads.Controllers;
import org.springframework.http.HttpStatus;
import com.example.mabayaonlinesponsoredads.DTOs.ProductDTO;
import com.example.mabayaonlinesponsoredads.Services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.SequenceInputStream;

@RestController
@RequestMapping("/promotedProduct")
public class AdController {
    private final AdService adService;
    private static final Logger logger = LoggerFactory.getLogger(AdController.class);
    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public ResponseEntity<ProductDTO> getPromotedProduct(
            @RequestParam String category) {

        try{
            ProductDTO productDTO = adService.getPromotedProduct(category);
            if (productDTO != null){
                return ResponseEntity.ok(productDTO);
            }
            logger.info("No promoted product found");
            return ResponseEntity.noContent().build();
        }
        catch (Exception e){
            logger.error("An error occurred " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProductDTO());
        }
        }
}

