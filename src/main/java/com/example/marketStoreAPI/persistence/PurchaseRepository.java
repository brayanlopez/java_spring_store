package com.example.marketStoreAPI.persistence;

import com.example.marketStoreAPI.domain.Purchase;
import com.example.marketStoreAPI.persistence.crud.PurchaseCrudRepository;
import com.example.marketStoreAPI.persistence.entity.PurchaseEntity;
import com.example.marketStoreAPI.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements com.example.marketStoreAPI.domain.repository.PurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<PurchaseEntity>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdClient(clientId)
                .map(purchases -> mapper.toPurchases(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = mapper.toPurchaseEntity(purchase);
        purchaseEntity.getProducts().forEach(product -> product.setPurchaseEntity(purchaseEntity));
        return mapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
    }
}