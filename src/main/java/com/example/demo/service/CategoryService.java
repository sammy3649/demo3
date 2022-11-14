package com.example.demo.service;

import com.example.demo.model.Attribute;
import com.example.demo.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> getCategoryByName(String categoryName);

    Category getCategory(Long id);

    Category deleteCategory(Long id);

    Category deleteCategoryByName(String categoryName);

    Category updateCategory(Category category);

    List<Category> findByCategoryName(String categoryName);

    List<String> getCategoryNameStartWith(String letter);

    Category updateCategoryWithNewAttribute(Long id, Attribute attribute);

    Category deleteAttributeInCategory(Long categoryId, Attribute attribute);

    // void getParentAttributes();
}
