package com.example.marketStoreAPI.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientEntity {

  @Id
  private String id;

  @Column(name = "nombre")
  private String name;

  @Column(name = "apellidos")
  private String lastName;

  @Column(name = "celular")
  private Long cellphone;

  @Column(name = "direccion")
  private String address;

  @Column(name = "correo_electronico")
  private String emailAddress;

  @OneToMany(mappedBy = "client")
  private List<PurchaseEntity> purchaseEntities;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Long getCellphone() {
    return cellphone;
  }

  public void setCellphone(Long cellphone) {
    this.cellphone = cellphone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public List<PurchaseEntity> getPurchases() {
    return purchaseEntities;
  }

  public void setPurchases(List<PurchaseEntity> purchaseEntities) {
    this.purchaseEntities = purchaseEntities;
  }
}
