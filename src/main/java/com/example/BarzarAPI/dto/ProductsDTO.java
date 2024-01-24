package com.example.BarzarAPI.dto;

import com.example.BarzarAPI.models.Category;
import com.example.BarzarAPI.models.Products;

public class ProductsDTO {
  private Products product;
  private Category category;

  public ProductsDTO(Products product, Category category) {
    this.product = product;
    this.category = category;
  }

  public Products getProduct() {
    return product;
  }

  public Category getCategory() {
    return category;
  }
}