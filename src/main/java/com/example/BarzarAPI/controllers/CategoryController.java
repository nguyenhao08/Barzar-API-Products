package com.example.BarzarAPI.controllers;

import com.example.BarzarAPI.models.Category;
import com.example.BarzarAPI.repositories.CategoryRepository;

import jakarta.servlet.http.HttpServletRequest;

import com.example.BarzarAPI.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  @GetMapping("/{id}")
  public Category getCategoryById(@PathVariable Long id) {
    return categoryRepository.findById(id).get();
  }

  @PostMapping
  public Category createCategory(@RequestBody Category category, HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    return categoryRepository.save(category);
  }

  @PutMapping("/{id}")
  public Category updateUser(@PathVariable Long id, @RequestBody Category category) {
    Category existingUser = categoryRepository.findById(id).get();
    existingUser.setTitle(category.getTitle());
    existingUser.setDescription(category.getDescription());
    return categoryRepository.save(existingUser);
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id) {
    try {
      categoryRepository.findById(id).get();
      categoryRepository.deleteById(id);
      return "Category deleted successfully";
    } catch (Exception e) {
      return "Category not found";
    }
  }

}