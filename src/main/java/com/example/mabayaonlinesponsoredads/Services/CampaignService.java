package com.example.mabayaonlinesponsoredads.Services;

import com.example.mabayaonlinesponsoredads.DTOs.CampaignDTO;
import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import com.example.mabayaonlinesponsoredads.Mappers.CampaignMapper;
import com.example.mabayaonlinesponsoredads.Repositories.CampaignRepository;
import com.example.mabayaonlinesponsoredads.Repositories.ProductRepository;
import com.example.mabayaonlinesponsoredads.Repositories.ProductsInCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Collections;


import java.util.List;
import java.util.Set;

@Service
public class CampaignService {
    private ProductRepository productRepository;
    private CampaignRepository campaignRepository;
    private ProductsInCampaignRepository productsInCampaignRepository;
    private final CampaignMapper campaignMapper;
    @Autowired
    public CampaignService(ProductRepository productRepository,CampaignRepository campaignRepository,ProductsInCampaignRepository productsInCampaignRepository, CampaignMapper campaignMapper) {
        this.productRepository = productRepository;
        this.campaignRepository = campaignRepository;
        this.productsInCampaignRepository = productsInCampaignRepository;
        this.campaignMapper = campaignMapper;

    }

    public CampaignDTO createCampaign(CampaignDTO campaignDTO){
        Campaign newCampaign = campaignMapper.campaignDTOToCampaign(campaignDTO);
        newCampaign = campaignRepository.save(newCampaign); // save new campaign
        List<Product> productList = productRepository.findAllById(campaignDTO.getProductIds());
        if (productList != null){
            // adding relationship between the new campaign and the relevant products
            for (Product product : productList){
                createRelationProductToCampaign (newCampaign, product);
            }
        }
        CampaignDTO newCampaignDTO =campaignMapper.campaignToCampaignDTO(newCampaign);
        newCampaignDTO.setProductIds(campaignDTO.getProductIds());
        return newCampaignDTO;
    }

    public List<Campaign> findValidCampaigns(List<ProductsInCampaign> productsInCampaignList) {
        LocalDate currentDate = LocalDate.now();
        // Filter campaigns that are valid (valid campaign = start date within 10 days from currentDate)
        List<Campaign> validCampaigns = productsInCampaignList.stream()
                .map(ProductsInCampaign::getCampaign)
                .filter(campaign -> {
                    LocalDate startDate = campaign.getStartDate().toLocalDateTime().toLocalDate();
                    long daysBetween = startDate.until(currentDate, java.time.temporal.ChronoUnit.DAYS);
                    return daysBetween >= 0 && daysBetween <= 10;
                })
                .collect(Collectors.toList());
        return validCampaigns;
    }

    public Campaign findCampaignWithMaxBid(List<Campaign> validCampaigns){
        return Collections.max(validCampaigns, Comparator.comparingDouble(Campaign::getBid));
    }

    private void createRelationProductToCampaign (Campaign newCampaign,Product product){
        ProductsInCampaign productsInCampaign = new ProductsInCampaign();
        productsInCampaign.setCampaign(newCampaign);
        productsInCampaign.setProduct(product);
        productsInCampaignRepository.save(productsInCampaign);
        Set<ProductsInCampaign> newProductsInCampaignSet = newCampaign.getProductsInCampaignSet();
        newProductsInCampaignSet.add(productsInCampaign);
        newCampaign.setProductsInCampaignSet(newProductsInCampaignSet);
    }
}
