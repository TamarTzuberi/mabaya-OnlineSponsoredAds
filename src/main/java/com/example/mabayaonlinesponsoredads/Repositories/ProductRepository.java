package com.example.mabayaonlinesponsoredads.Repositories;

import com.example.mabayaonlinesponsoredads.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(String category);
    Product findByProductId(long promotedProductId);
}
