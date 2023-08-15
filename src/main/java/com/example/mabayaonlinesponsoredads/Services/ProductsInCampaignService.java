package com.example.mabayaonlinesponsoredads.Services;

import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import com.example.mabayaonlinesponsoredads.Repositories.ProductsInCampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsInCampaignService {
    private final ProductsInCampaignRepository productsInCampaignRepository;

    @Autowired
    public ProductsInCampaignService(ProductsInCampaignRepository productsInCampaignRepository) {
        this.productsInCampaignRepository = productsInCampaignRepository;
    }

    public List<ProductsInCampaign> getProductsInCampaign(List<Product> productList) {
        return productsInCampaignRepository.findByProductIn(productList);
    }

    public List<ProductsInCampaign> getAllCampaignsWithProducts() {
        return productsInCampaignRepository.findDistinctByCampaign();
    }
}
