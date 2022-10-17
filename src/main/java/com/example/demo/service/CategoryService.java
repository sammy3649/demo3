package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> getCategoryByName(String categoryName);

    Category getCategory(Integer id);

    Category deleteCategory(Integer id);

    Category deleteCategoryByName(String categoryName);

    Category updateCategory(Category category);

    List<Category> findByCategoryName(String categoryName);

    List<String> getCategoryNameStartWith();
}
