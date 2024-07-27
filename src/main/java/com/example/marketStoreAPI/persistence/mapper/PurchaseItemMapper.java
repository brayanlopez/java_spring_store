package com.example.marketStoreAPI.persistence.mapper;

import com.example.marketStoreAPI.domain.PurchaseItem;
import com.example.marketStoreAPI.persistence.entity.PurchaseProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idPurchase", target = "productId"),
            @Mapping(source = "amount", target = "quantity"),
            @Mapping(source = "total", target = "total")
    })
    PurchaseItem toPurchaseItem(PurchaseProductEntity product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchaseEntity", ignore = true),
            @Mapping(target = "productEntity", ignore = true),
            @Mapping(target = "id.idProduct", ignore = true)
    })
    PurchaseProductEntity toPurchaseProduct(PurchaseItem item);
}