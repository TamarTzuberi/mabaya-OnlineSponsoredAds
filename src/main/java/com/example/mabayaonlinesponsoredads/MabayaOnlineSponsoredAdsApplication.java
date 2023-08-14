package com.example.mabayaonlinesponsoredads;

import com.example.mabayaonlinesponsoredads.Entities.Product;
import com.example.mabayaonlinesponsoredads.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Random;

@SpringBootApplication
public class MabayaOnlineSponsoredAdsApplication {
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(MabayaOnlineSponsoredAdsApplication.class, args);
	}

	@Component
	public class ProductDBInitializer implements CommandLineRunner {
		private final String[] categories = {"Electronics", "Beauty", "Home",};
		private final Random random = new Random();

		@Override
		public void run(String... args) throws Exception {
			for (int i = 0; i < 10; i++) {
				Product product = new Product();
				product.setTitle("Product " + (i + 1));
				product.setCategory(categories[random.nextInt(categories.length)]);
				product.setPrice(10.0 + random.nextDouble() * 100.0);
				product.setpSerialNum(100 + i); // making a unique serial number
				productRepository.save(product);
			}
		}
	}
}
