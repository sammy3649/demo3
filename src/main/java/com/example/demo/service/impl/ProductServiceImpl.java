package com.example.demo.service.impl;

import com.example.demo.model.Attribute;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.AttributeRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.AttributeService;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final AttributeRepository attributeRepository;
    private final AttributeService attributeServicel;

    private static final String SOURCE_URL = "http://127.0.0.1:8080/";
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, AttributeRepository attributeRepository, AttributeService attributeServicel) {
        this.productRepository = productRepository;
        this.attributeRepository = attributeRepository;
        this.attributeServicel = attributeServicel;
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
        log.info("Was invoked method for get product {}", id);
        return productRepository.findById(id).orElse(null);
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
    public List<String> getProductNameStartWith(String letter) {
        return null;
    }

    @Override
    public List<String> getProductNameStartWith(Character letter) {
        log.info("Was invoked method to get product starting with ");
        return productRepository.findAll().stream().parallel()
                .map(Product::getName)
                .map(String::toUpperCase)
                .filter(a -> a.startsWith(String.valueOf(letter)))
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Product updateProductWithNewAttribute(Long id, Attribute attribute) {
        Product product = getProduct(id);
        if (product.getAttribute() == null) {
            product.setAttribute(new ArrayList<>());
        }
        product.getAttribute().add(attribute);
        return productRepository.save(product);
    }

}
