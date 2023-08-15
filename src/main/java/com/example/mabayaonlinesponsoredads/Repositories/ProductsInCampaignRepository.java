package com.example.mabayaonlinesponsoredads.Repositories;

import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsInCampaignRepository extends JpaRepository<ProductsInCampaign, Long> {
    List<ProductsInCampaign> findByProductIn(List<Product> productList);
    List<ProductsInCampaign> findDistinctByCampaign();
}
