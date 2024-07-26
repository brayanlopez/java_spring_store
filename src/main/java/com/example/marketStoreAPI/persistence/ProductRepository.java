package com.example.marketStoreAPI.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.marketStoreAPI.persistence.crud.ProductCrudRepository;
import com.example.marketStoreAPI.persistence.entity.ProductEntity;

@Repository
public class ProductRepository {

  private ProductCrudRepository productRepository;

  public List<ProductEntity> getAll() {
    return (List<ProductEntity>) productRepository.findAll();
  }

  public List<ProductEntity> getByCategory(int idCategory) {
    return productRepository.findByIdCategoryOrderByNameAsc(idCategory);
  }

  public Optional<List<ProductEntity>> getFewer(int stockAmount) {
    return productRepository.findByStockAmountLessThanAndStatus(stockAmount, true);
  }

  public Optional<ProductEntity> getProduct(int idProduct) {
    return productRepository.findById(idProduct);
  }

  public ProductEntity save(ProductEntity productEntity) {
    return productRepository.save(productEntity);
  }

  public void delete(int idProduct) {
    productRepository.deleteById(idProduct);
  }

}
