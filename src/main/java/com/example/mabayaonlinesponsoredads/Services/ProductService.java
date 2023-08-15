package com.example.mabayaonlinesponsoredads.Services;

import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product getProductByProductId(long promotedProductId) {
        return productRepository.findByProductId(promotedProductId);
    }
}
