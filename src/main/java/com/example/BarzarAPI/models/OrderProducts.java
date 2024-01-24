package com.example.BarzarAPI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders_product")
public class OrderProducts {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String phonenumber;

  @Column
  private String address;

  @Column
  private String paymentmethod;

  @Column
  private String total;

  @Column
  private String grandtotal;

  @Column
  private String cartitems;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phonenumber;
  }

  public void setPhoneNumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPaymentMethod() {
    return paymentmethod;
  }

  public void setPaymentMethod(String paymentmethod) {
    this.paymentmethod = paymentmethod;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getGrandTotal() {
    return grandtotal;
  }

  public void setGrandTotal(String grandtotal) {
    this.grandtotal = grandtotal;
  }

  public String getCartItems() {
    return cartitems;
  }

  public void setCartItems(String cartitems) {
    this.cartitems = cartitems;
  }
}
