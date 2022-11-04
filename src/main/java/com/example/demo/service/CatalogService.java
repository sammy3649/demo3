package com.example.demo.service;

import com.example.demo.model.Catalog;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

import java.util.List;

public interface CatalogService {
    Catalog createCatalog(Catalog catalog);

    Catalog getCatalog(Long id);

    Catalog deleteCatalog(Long id);

    Catalog deleteCatalogByName(String name);

    Catalog updateCatalog(Catalog catalog);

    Catalog findByName(String name);

    Catalog saveCategoryAndProduct(Product product, Category category);

    List<String> getProductNameStartWith(String letter);
}
