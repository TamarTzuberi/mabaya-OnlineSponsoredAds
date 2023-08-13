package com.example.mabayaonlinesponsoredads.Services;

import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import com.example.mabayaonlinesponsoredads.Repositories.CampaignRepository;
import com.example.mabayaonlinesponsoredads.Repositories.ProductRepository;
import com.example.mabayaonlinesponsoredads.Repositories.ProductsInCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
