package com.example.mabayaonlinesponsoredads.Services;

import com.example.mabayaonlinesponsoredads.DTOs.ProductDTO;
import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import com.example.mabayaonlinesponsoredads.Mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {
    private final ProductService productService;
    private final ProductsInCampaignService productsInCampaignService;
    private final CampaignService campaignService;
    private final ProductMapper productMapper;


    @Autowired
    public AdService(ProductService productService,ProductsInCampaignService productsInCampaignService,CampaignService campaignService, ProductMapper productMapper) {
        this.productService = productService;
        this.productsInCampaignService = productsInCampaignService;
        this.campaignService = campaignService;
        this.productMapper = productMapper;
    }

    public ProductDTO getPromotedProduct(String category){
        List<Product> categoryProducts = productService.getProductsByCategory(category);
        List<ProductsInCampaign> productsInCampaigns =productsInCampaignService.getProductsInCampaign(categoryProducts);
        List<Campaign> validCampaigns = campaignService.findValidCampaigns(productsInCampaigns);
        if (!validCampaigns.isEmpty()) {
            // In case that there are valid campaigns that contains product that related to the required category : find the campaign with the max bid
            return findPromotedProductFromProductsInCampaign(productsInCampaigns, validCampaigns);
        }
        //In case that there are no valid campaigns containing products related to the required category : find all valid campaigns and determine which one has the highest bid
        productsInCampaigns = productsInCampaignService.getAllCampaignsWithProducts();
        validCampaigns = campaignService.findValidCampaigns(productsInCampaigns);
        if (!validCampaigns.isEmpty()) {
            // In case that there are valid campaigns that contains products in the DB
            return findPromotedProductFromProductsInCampaign(productsInCampaigns, validCampaigns);
        }
        return null;
    }


    private ProductDTO findPromotedProductFromProductsInCampaign(List<ProductsInCampaign> productsInCampaigns, List<Campaign> validCampaigns){
        Campaign campaignWithMaxBid = campaignService.findCampaignWithMaxBid(validCampaigns);
        long promotedProductId = productsInCampaigns.stream()
                .filter(productsInCampaign -> productsInCampaign.getCampaign().getCampaignId().equals(campaignWithMaxBid.getCampaignId()))
                .map(productsInCampaign -> productsInCampaign.getProduct().getProductId())
                .findFirst()
                .orElse(null);
        Product promotedProduct = productService.getProductByProductId(promotedProductId);
        return productMapper.productToProductDTO(promotedProduct);
    }


}
