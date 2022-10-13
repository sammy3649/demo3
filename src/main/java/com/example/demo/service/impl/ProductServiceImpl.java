package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private static final String SOURCE_URL = "http://127.0.0.1:8080/";
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        log.info("Was invoked method for create  product {}", product);
        return productRepository.save(product);
    }

    @Override
    public Product getProductByName(String name) {
        log.info("Was invoked method for get product {}", name);
        return productRepository.findProductByName(name);
    }

    @Override
    public Product getProduct(Long id) {
        log.info("Was invoked method for get  product {}", id);
        return productRepository.findProductById(id).get();
    }

    @Override
    public Product deleteProduct(Long id) {
        log.info("Was invoked method for delete  product {}", id);
        productRepository.deleteProductById(id);
        return null;
    }

    @Override
    public Product deleteProductByName(String name) {
        log.info("Was invoked method for delete  product {}", name);
        productRepository.deleteProductByName(name);
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        log.info("Was invoked method for update  product {}", product);
        return productRepository.save(product);
    }

    @Override
    public List<Product> findProductByCategory(Category category) {
        log.info("Was invoked method to find by category name  {}", category);
        return productRepository.findProductByCategory(category);
    }

    @Override
    public List<String> getProductNameStartWith() {
        log.info("Was invoked method to get product starting with ");
        return productRepository.findAll().stream().parallel()
                .map(Product::getName)
                .map(String::toUpperCase)
                .filter(a -> a.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }
}
