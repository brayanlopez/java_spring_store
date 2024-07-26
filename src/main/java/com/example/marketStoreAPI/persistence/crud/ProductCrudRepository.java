package com.example.marketStoreAPI.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.marketStoreAPI.persistence.entity.ProductEntity;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

  @Query(value = "SELECT * FROM productos WHERE cantidad_stock = ?", nativeQuery = true)
  List<ProductEntity> findByIdCategoryOrderByNameAsc(Integer idCategory);

  @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
  Optional<List<ProductEntity>> findByStockAmountLessThanAndStatus(int stockAmount, boolean status);

}
