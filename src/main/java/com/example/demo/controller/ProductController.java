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

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return getResponse(product);
    }

    // @GetMapping("{name}")
    //public ResponseEntity<Product> getProductByName(@PathVariable String name) {
    //   Product productByName = productService.getProductByName(name);
    //   if (productByName == null) {
    //       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //   }
    //   return ResponseEntity.ok(productByName);

    //  }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product putProduct = productService.updateProduct(product);
        if (putProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putProduct);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Product deleteProduct = productService.deleteProduct(id);
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

    @PostMapping("/{id}/add-attribute")
    public ResponseEntity<Product> updateNewProduct(@PathVariable Long id, @RequestBody Attribute attribute) {
        Product putNewProduct = productService.updateProductWithNewAttribute(id, attribute);
        if (putNewProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putNewProduct);
    }
    @DeleteMapping("/{id}/delete-attribute")
    public ResponseEntity<Product> removeAttributeInProduct(@PathVariable Long id, @RequestBody Attribute attribute) {
        Product putNewProduct = productService.deleteAttributeInProduct(id, attribute);
        if (putNewProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putNewProduct);
    }


    private ResponseEntity<Product> getResponse(Product product) {
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

}
