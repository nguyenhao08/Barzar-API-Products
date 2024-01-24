package com.example.BarzarAPI.repositories;

import com.example.BarzarAPI.models.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

}