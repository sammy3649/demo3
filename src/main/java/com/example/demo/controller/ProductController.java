package com.example.demo.controller;

import com.example.demo.model.Attribute;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        Product product = productService.getProduct(productId);
        return getResponse(product);
    }

    @GetMapping(params = {"name"})
    public List<Product> findByProductName(@RequestParam(required = false) String name) {
        return productService.getProductByName(name);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product putProduct = productService.updateProduct(product);
        if (putProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putProduct);

    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long productId) {
        Product deleteProduct = productService.deleteProduct(productId);
        if (deleteProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deleteProduct);
    }

    @DeleteMapping(params = {"name"})
    public Product deleteByName(String name) {
        return productService.deleteProductByName(name);
    }

    @GetMapping(params = {"categoryName"})
    public List<Product> findProductByCategory(@RequestBody Category category) {
        return productService.findProductByCategory(category);
    }

    @GetMapping("/startwith")
    public List<String> getProductNameStartWith(@RequestParam String letter) {
        return productService.getProductNameStartWith(letter);
    }

    @GetMapping("/allproducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/{productId}/add-attribute")
    public ResponseEntity<Product> updateNewProduct(@PathVariable Long productId, @RequestBody Attribute attribute) {
        Product putNewProduct = productService.updateProductWithNewAttribute(productId, attribute);
        if (putNewProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putNewProduct);
    }

    @DeleteMapping("/{productId}/delete-attribute")
    public ResponseEntity<Product> removeAttributeInProduct(@PathVariable Long productId,@RequestBody Attribute attribute) {
        Product deletedProduct = productService.deleteAttributeInProduct(productId, attribute);
        if (deletedProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deletedProduct);
    }


    private ResponseEntity<Product> getResponse(Product product) {
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

}
