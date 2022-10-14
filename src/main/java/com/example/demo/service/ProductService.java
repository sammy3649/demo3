package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product getProductByName(String name);

  //  Product getProduct(Long id);

    Product getProduct(Integer id);

    Product deleteProduct(Integer id);

    Product deleteProductByName(String name);

    Product updateProduct(Product product);

    List<Product> findProductByCategory(Category category);

    List<String> getProductNameStartWith(String letter);
}
