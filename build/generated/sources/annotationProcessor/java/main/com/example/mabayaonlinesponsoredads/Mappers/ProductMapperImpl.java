package com.example.mabayaonlinesponsoredads.Mappers;

import com.example.mabayaonlinesponsoredads.DTOs.ProductDTO;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-16T00:27:30+0300",
    comments = "version: 1.4.0.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setTitle( product.getTitle() );
        productDTO.setCategory( product.getCategory() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setpSerialNum( product.getpSerialNum() );

        return productDTO;
    }

    @Override
    public Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setTitle( productDTO.getTitle() );
        product.setCategory( productDTO.getCategory() );
        product.setPrice( productDTO.getPrice() );
        product.setpSerialNum( productDTO.getpSerialNum() );

        return product;
    }
}
