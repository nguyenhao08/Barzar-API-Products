package com.example.BarzarAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.BarzarAPI.models.OrderProducts;

@Repository
public interface OrdersProductsRepository extends JpaRepository<OrderProducts, Long> {
  // Các phương thức tùy chỉnh nếu cần
}
