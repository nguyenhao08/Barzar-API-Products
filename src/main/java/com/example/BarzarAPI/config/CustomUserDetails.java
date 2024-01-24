package com.example.BarzarAPI.config;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetails extends UserDetails {

  // Thêm phương thức mới để lấy danh sách các roles
  Collection<String> getRoles();
}