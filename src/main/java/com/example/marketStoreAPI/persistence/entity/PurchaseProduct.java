package com.example.marketStoreAPI.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "compras_productos")
public class PurchaseProduct {
    @EmbeddedId
    private PurchaseProductPk id;

    @Column(name = "cantidad")
    private Integer amount;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    // @OneToMany(mappedBy = "product")
    // private List<PurchaseProduct> products;

    public PurchaseProductPk getId() {
        return id;
    }

    public void setId(PurchaseProductPk id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}