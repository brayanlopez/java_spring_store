package com.example.marketStoreAPI.persistence.mapper;

import com.example.marketStoreAPI.domain.Purchase;
import com.example.marketStoreAPI.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items")
    })
    Purchase toPurchase(PurchaseEntity compra);
    List<Purchase> toPurchases(List<PurchaseEntity> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    PurchaseEntity toPurchaseEntity(Purchase purchase);
}