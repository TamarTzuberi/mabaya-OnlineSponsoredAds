package com.example.mabayaonlinesponsoredads.Repositories;

import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Entities.ProductsInCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductsInCampaignRepository extends JpaRepository<ProductsInCampaign,Long> {
    public List<ProductsInCampaign> findByProductIn(List<Product> productList);
    @Query("SELECT pic FROM ProductsInCampaign pic " +
            "WHERE pic.id IN " +
            "(SELECT MIN(sub.id) FROM ProductsInCampaign sub GROUP BY sub.campaign)")
    List<ProductsInCampaign> findDistinctProductsInCampaign();


}
