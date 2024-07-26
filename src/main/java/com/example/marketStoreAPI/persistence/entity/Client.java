package com.example.marketStoreAPI.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

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
  private List<Purchase> purchases;

}
