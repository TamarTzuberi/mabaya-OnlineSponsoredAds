package com.example.mabayaonlinesponsoredads.Repositories;

import com.example.mabayaonlinesponsoredads.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(String category);
    Product findByProductId(long promotedProductId);
}
