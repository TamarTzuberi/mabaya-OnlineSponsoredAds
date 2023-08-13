package com.example.mabayaonlinesponsoredads;

import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MabayaOnlineSponsoredAdsApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(MabayaOnlineSponsoredAdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = new Product("title1","Home",12.3,123);
		productRepository.save(product1);
		Product product2 = new Product("title3","Electro",124.3,15623);
		productRepository.save(product2);

	}
}
