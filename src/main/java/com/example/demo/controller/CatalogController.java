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
    public Catalog createCatalog(@RequestBody Catalog catalog) {
        return catalogService.createCatalog(catalog);
    }

    @GetMapping("{id}")
    public ResponseEntity<Catalog> getCatalog(@PathVariable Integer id) {
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
    public ResponseEntity<Catalog> deleteCatalog(@PathVariable Integer id) {
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
