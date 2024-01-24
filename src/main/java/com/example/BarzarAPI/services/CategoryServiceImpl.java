// package com.example.BarzarAPI.services;

// import com.example.BarzarAPI.models.Category;
// import com.example.BarzarAPI.repositories.CategoryRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CategoryServiceImpl implements CategoryService {
// private final CategoryRepository categoryRepository;

// @Autowired
// public CategoryServiceImpl(CategoryRepository categoryRepository) {
// this.categoryRepository = categoryRepository;
// }

// @Override
// public List<Category> getAllCategories() {
// return categoryRepository.findAll();
// }

// @Override
// public Category findCategory(String title, String description, Long id) {
// return categoryRepository.findCategory(title, description, id);
// }
// }