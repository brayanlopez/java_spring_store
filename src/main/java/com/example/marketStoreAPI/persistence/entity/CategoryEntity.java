package com.example.marketStoreAPI.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class  CategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_categoria")
  private Integer idCategory;

  @Column(name = "descripcion")
  private String description;

  @Column(name = "estado")
  private Boolean status;

  @OneToMany(mappedBy = "category")
  private List<ProductEntity> productEntities;

  public Integer getIdCategory() {
    return idCategory;
  }

  public void setIdCategory(Integer idCategory) {
    this.idCategory = idCategory;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public List<ProductEntity> getProducts() {
    return productEntities;
  }

  public void setProducts(List<ProductEntity> productEntities) {
    this.productEntities = productEntities;
  }
}
