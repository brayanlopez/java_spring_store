package com.example.marketStoreAPI.persistence.mapper;

import com.example.marketStoreAPI.domain.Product;
import com.example.marketStoreAPI.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "sellValue", target = "price"),
            @Mapping(source = "stockAmount", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "categoryEntity", target = "category"),
    })
    Product toProduct(ProductEntity product);

    List<Product> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    ProductEntity toProductEntity(Product product);
}
