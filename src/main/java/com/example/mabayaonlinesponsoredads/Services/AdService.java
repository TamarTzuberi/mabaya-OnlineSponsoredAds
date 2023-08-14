package com.example.mabayaonlinesponsoredads.Services;

import com.example.mabayaonlinesponsoredads.DTOs.ProductDTO;
import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {
    private final ProductService productService;
    private final ProductsInCampaignService productsInCampaignService;
    private final CampaignService campaignService;

    @Autowired
    public AdService(ProductService productService,ProductsInCampaignService productsInCampaignService,CampaignService campaignService) {
        this.productService = productService;
        this.productsInCampaignService = productsInCampaignService;
        this.campaignService = campaignService;
    }

    public ProductDTO getPromotedProduct(String category){
        List<Product> categoryProducts = productService.getProductsByCategory(category);
        List<ProductsInCampaign> productsInCampaigns =productsInCampaignService.getProductsInCampaign(categoryProducts);
        List<Campaign> validCampaigns = campaignService.findValidCampaigns(productsInCampaigns);
        if (!validCampaigns.isEmpty()) {
            // In case that there are valid campaigns that contains product that related to the required category : find the campaign with the max bid
            return findPromotedProduct(productsInCampaigns, validCampaigns);
        }
        //In case that there are no valid campaigns containing products related to the required category : find all valid campaigns and determine which one has the highest bid
        productsInCampaigns = productsInCampaignService.getAllProductsInCampaign();
        validCampaigns = campaignService.findValidCampaigns(productsInCampaigns);
        if (!validCampaigns.isEmpty()) {
            // In case that there are valid campaigns that contains products in the DB
            return findPromotedProduct(productsInCampaigns, validCampaigns);
        }
        return null;
    }


    //Todo: update this function (with all the required fields) and add new mapper class
    private ProductDTO ConvertToDto(Product promotedProduct) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setTitle(promotedProduct.getTitle());
        return productDTO;
    }

    private ProductDTO findPromotedProduct(List<ProductsInCampaign> productsInCampaigns, List<Campaign> validCampaigns){
        Campaign campaignWithMaxBid = campaignService.findCampaignWithMaxBid(validCampaigns);
        long promotedProductId = productsInCampaigns.stream()
                .filter(productsInCampaign -> productsInCampaign.getCampaign().getCampaignId().equals(campaignWithMaxBid.getCampaignId()))
                .map(productsInCampaign -> productsInCampaign.getProduct().getProductId())
                .findFirst()
                .orElse(null);
        Product promotedProduct = productService.getProductByProductId(promotedProductId);
        return ConvertToDto(promotedProduct);
    }


}
