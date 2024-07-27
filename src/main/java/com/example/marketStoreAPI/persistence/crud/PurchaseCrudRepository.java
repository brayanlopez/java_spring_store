package com.example.marketStoreAPI.persistence.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.marketStoreAPI.persistence.entity.PurchaseEntity;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {
    @Query(value = "SELECT * FROM clientes WHERE id = ?", nativeQuery = true)
    Optional<List<PurchaseEntity>> findByIdClient(String idCliente);
}