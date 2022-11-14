package com.example.demo.controller;

import com.example.demo.model.Attribute;
import com.example.demo.model.Catalog;
import com.example.demo.model.Product;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;
    private final CatalogRepository catalogRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;


    public CatalogController(CatalogService catalogService, CatalogRepository catalogRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.catalogService = catalogService;
        this.catalogRepository = catalogRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Catalog> createCatalog(@RequestBody Catalog catalog) {
        catalogRepository.save(catalog);
        categoryRepository.saveAll(catalog.getCategories());
        catalog.getCategories().forEach(category -> {
            List<Product> products = category.getProducts();
            productRepository.saveAll(products);
        });
        return ResponseEntity.ok().build();
    }

    @GetMapping("{catalogId}")
    public ResponseEntity<Catalog> getCatalog(@PathVariable Long catalogId) {
        Catalog catalog = catalogService.getCatalog(catalogId);
        if (catalog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(catalog);

    }

    @PutMapping
    public ResponseEntity<Catalog> updateCatalog(@RequestBody Catalog catalog) {
        Catalog putCatalog = catalogService.updateCatalog(catalog);
        if (putCatalog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putCatalog);

    }

    @DeleteMapping("{catalogId}")
    public ResponseEntity<Catalog> deleteCatalog(@PathVariable Long catalogId) {
        Catalog deleteCatalog = catalogService.deleteCatalog(catalogId);
        if (deleteCatalog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deleteCatalog);
    }

    @GetMapping(params = {"name"})
    public Catalog findByName(
            @RequestParam(required = false) String name) {
        return catalogService.findByName(name);
    }

    @GetMapping("/all")
    public List<Catalog> getAll() {
        return catalogRepository.findAll();
    }

    @GetMapping("/startwith")
    public List<String> getProductNameStartWith(@RequestParam String letter) {
        return catalogService.getProductNameStartWith(letter);
    }

    @DeleteMapping(params = {"name"})
    public Catalog deleteByName(
            @RequestParam(required = false) String name) {
        return catalogService.deleteCatalogByName(name);
    }

    @PostMapping("/{catalogId}/add-attribute")
    public ResponseEntity<Catalog> updateNewCatalog(@PathVariable Long catalogId, @RequestBody Attribute attribute) {
        Catalog putNewCatalog = catalogService.updateCatalogWithNewAttribute(catalogId, attribute);
        if (putNewCatalog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putNewCatalog);
    }

    @DeleteMapping("/{catalogId}/delete-attribute")
    public ResponseEntity<Catalog> removeAttributeInCatalog(@PathVariable Long catalogId, @RequestBody Attribute attribute) {
        Catalog deletedCatalog = catalogService.deleteAttributeInCatalog(catalogId, attribute);
        if (deletedCatalog == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deletedCatalog);
    }

}


