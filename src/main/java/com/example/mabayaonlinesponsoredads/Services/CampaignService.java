package com.example.mabayaonlinesponsoredads.Services;

import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import com.example.mabayaonlinesponsoredads.Repositories.CampaignRepository;
import com.example.mabayaonlinesponsoredads.Repositories.ProductRepository;
import com.example.mabayaonlinesponsoredads.Repositories.ProductsInCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Collections;



import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class CampaignService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private ProductsInCampaignRepository productsInCampaignRepository;

    public Campaign createCampaign(String name, Timestamp startDate, List<Long> productIds, double bid){
        Campaign campaign = new Campaign(name, startDate, bid);
        campaign = campaignRepository.save(campaign); // save new campaign
        List<Product> productList = productRepository.findAllById(productIds);
        if (productList != null){
            // adding relationship between the new campaign and the relevant products
            for (Product product : productList){
                ProductsInCampaign productsInCampaign = new ProductsInCampaign();
                productsInCampaign.setCampaign(campaign);
                productsInCampaign.setProduct(product);
                productsInCampaignRepository.save(productsInCampaign);
                Set<ProductsInCampaign> newProductsInCampaignSet = campaign.getProductsInCampaignSet();
                newProductsInCampaignSet.add(productsInCampaign);
                campaign.setProductsInCampaignSet(newProductsInCampaignSet);
            }
        }
        return campaignRepository.save(campaign);
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
}
