package com.example.mabayaonlinesponsoredads.Mappers;
import com.example.mabayaonlinesponsoredads.DTOs.ProductDTO;
import com.example.mabayaonlinesponsoredads.Entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);
}
