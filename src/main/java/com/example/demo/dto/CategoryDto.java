package com.example.demo.dto;

import com.example.demo.model.Catalog;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryDto implements Serializable {
    private final String categoryId;
    private String categoryName;
    private Catalog catalog;
    private List<Product> products;
    private List<Category> categories;
}
