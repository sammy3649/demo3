package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(product);

    }
    @GetMapping("{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product productByName = productService.getProductByName(name);
        if (productByName == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(productByName);

    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product putProduct = productService.updateProduct(product);
        if (putProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putProduct);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        Product deleteProduct = productService.deleteProduct(id);
        if (deleteProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deleteProduct);
    }

    @DeleteMapping("{name}")
    public ResponseEntity<Product> deleteProductByName(@PathVariable String name) {
        Product deleteByName = productService.deleteProductByName(name);
        if (deleteByName == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deleteByName);
    }

    @GetMapping(params = {"categoryName"})
    public List<Product> findProductByCategory(@RequestBody Category category) {
        return productService.findProductByCategory(category);
    }

    @GetMapping("/startwitha")
    public List<String> getProductNameStartWithA() {
        return productService.getProductNameStartWith();
    }
}
