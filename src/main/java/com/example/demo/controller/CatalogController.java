package com.example.demo.controller;

import com.example.demo.model.Catalog;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    private final CatalogRepository catalogRepository;
    private final CatalogService catalogService;

    public CatalogController(CatalogRepository catalogRepository, CatalogService catalogService) {
        this.catalogRepository = catalogRepository;
        this.catalogService = catalogService;
    }

    @PostMapping
    public ResponseEntity<Catalog> addCatalog(@RequestBody Catalog catalog) {
        Catalog newCatalog = catalogService.addCatalog(catalog);
        return ResponseEntity.ok(newCatalog);
    }

    @GetMapping("{id}")
    public ResponseEntity<Catalog> getCatalog(@PathVariable Long id) {
        Catalog catalog = catalogService.getCatalog(id);
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

    @DeleteMapping("{id}")
    public ResponseEntity<Catalog> deleteCatalog(@PathVariable Long id) {
        Catalog deleteCatalog = catalogService.deleteCatalog(id);
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

}
