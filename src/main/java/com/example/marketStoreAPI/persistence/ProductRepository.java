package com.example.marketStoreAPI.persistence;

import java.util.List;
import java.util.Optional;

import com.example.marketStoreAPI.domain.Product;
import com.example.marketStoreAPI.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.marketStoreAPI.persistence.crud.ProductCrudRepository;
import com.example.marketStoreAPI.persistence.entity.ProductEntity;

@Repository
public class ProductRepository implements com.example.marketStoreAPI.domain.repository.ProductRepository {

    @Autowired(required = true)
    private ProductCrudRepository productRepository;

    @Autowired(required = true)
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> products = (List<ProductEntity>) productRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> products = productRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<ProductEntity>> products = productRepository.findByStockAmountLessThanAndStatus(quantity, true);
        return products.map(product -> mapper.toProducts(product));
    }

    @Override
    public Optional<Product> getProduct(int idProduct) {
        return productRepository.findById(idProduct).map(product -> mapper.toProduct(product));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = mapper.toProductEntity(product);
        return mapper.toProduct(productRepository.save(productEntity));
    }

    @Override
    public void delete(int idProduct) {
        productRepository.deleteById(idProduct);
    }

}
