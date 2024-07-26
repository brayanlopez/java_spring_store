package com.example.marketStoreAPI.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.marketStoreAPI.persistence.crud.ProductCrudRepository;
import com.example.marketStoreAPI.persistence.entity.Product;

@Repository
public class ProductRepository {

  private ProductCrudRepository productRepository;

  public List<Product> getAll() {
    return (List<Product>) productRepository.findAll();
  }

  public List<Product> getByCategory(int idCategory) {
    return productRepository.findByIdCategoryOrderByNameAsc(idCategory);
  }

  public Optional<List<Product>> getFewer(int stockAmount) {
    return productRepository.findByStockAmountLessThanAndStatus(stockAmount, true);
  }

  public Optional<Product> getProduct(int idProduct) {
    return productRepository.findById(idProduct);
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public void delete(int idProduct) {
    productRepository.deleteById(idProduct);
  }

}
