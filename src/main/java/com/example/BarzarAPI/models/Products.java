package com.example.BarzarAPI.models;

import java.math.BigDecimal;
import java.time.LocalDateTime; // Import thư viện LocalDateTime
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String title;

  @Column
  private String description;

  @Column(precision = 10, scale = 2)
  private BigDecimal price;

  @Column
  private Integer stock;

  @Column
  private String images;

  @Column
  private String category;

  @Column
  private LocalDateTime createdat; // Thêm trường createdAt kiểu LocalDateTime

  @Column
  private LocalDateTime updatedat;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public LocalDateTime getCreatedAt() {
    return createdat;
  }

  public void setCreatedAt(LocalDateTime createdat) {
    this.createdat = createdat;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedat;
  }

  public void setgetUpdatedAt(LocalDateTime updatedat) {
    this.updatedat = updatedat;
  }
}
