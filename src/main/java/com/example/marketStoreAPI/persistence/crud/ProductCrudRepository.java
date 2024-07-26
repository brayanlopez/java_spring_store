package com.example.marketStoreAPI.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.marketStoreAPI.persistence.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
  List<Product> findByIdCategoryOrderByNameAsc(Integer idCategory);

  Optional<List<Product>> findByStockAmountLessThanAndStatus(int stockAmount, boolean status);

}
