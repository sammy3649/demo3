package com.example.demo.service;

import com.example.demo.model.Attribute;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getProductByName(String name);

    Product getProduct(Long productId);

    Product deleteProduct(Long productId);

    Product deleteProductByName(String name);

    Product updateProduct(Product product);

    List<Product> findProductByCategory(Category category);

    List<String> getProductNameStartWith(String letter);

    Product updateProductWithNewAttribute(Long productId, Attribute attribute);

    Product deleteAttributeInProduct(Long productId, Attribute attribute);
}
