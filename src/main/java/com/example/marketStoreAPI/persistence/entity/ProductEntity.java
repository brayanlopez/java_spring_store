package com.example.marketStoreAPI.persistence.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProduct;

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "codigo_barras")
    private String barcode;

    @Column(name = "precio_venta")
    private String sellValue;

    @Column(name = "cantidad_stock")
    private String stockAmount;

    @Column(name = "estado")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity")
    private List<PurchaseProductEntity> purchaseProduct;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSellValue() {
        return sellValue;
    }

    public void setSellValue(String sellValue) {
        this.sellValue = sellValue;
    }

    public String getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(String stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
