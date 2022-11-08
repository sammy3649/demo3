package com.example.demo.service.impl;

import com.example.demo.model.Attribute;
import com.example.demo.model.Catalog;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CatalogServiceImpl implements CatalogService {
//    private final MongoTemplate mongoTemplate;
    private final CatalogRepository catalogRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private static final String SOURCE_URL = "http://127.0.0.1:8080/";
    private static final Logger log = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.catalogRepository = catalogRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Catalog createCatalog(Catalog catalog) {
        log.info("Was invoked method for create catalog {}", catalog);
        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog getCatalog(Long id) {
        log.info("Was invoked method to get catalog {}", id);
        return catalogRepository.findById(id).get();
    }

    @Override
    public Catalog deleteCatalog(Long id) {
        log.info("Was invoked method for delete catalog {}", id);
        catalogRepository.deleteById(id);
        return null;
    }
    @Override
    public Catalog deleteCatalogByName(String name) {
        log.info("Was invoked method for delete catalog {}", name);
        catalogRepository.deleteCatalogByName(name);
        return null;
    }

    @Override
    public Catalog updateCatalog(Catalog catalog) {
        log.info("Was invoked method for update catalog {}", catalog);
        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog findByName(String name) {
        log.info("Was invoked method to find by name {}", name);
        return catalogRepository.findByName(name);
    }
    @ModelAttribute
    public Model addAttributes(Model model) {
        return model.addAttribute(model);    }
    @Override
    public Catalog saveCategoryAndProduct(Product product, Category category) {
        categoryRepository.insert(category);
        productRepository.insert(product);
        return saveCategoryAndProduct(product, category);
    }
    @Override
    public List<String> getProductNameStartWith(String letter) {
        log.info("Was invoked method to get product starting with ");
        return catalogRepository.findAll().stream().parallel()
                .map(Catalog::getName)
                .map(String::toUpperCase)
                .filter(a -> a.startsWith(String.valueOf(letter)))
                .sorted()
                .collect(Collectors.toList());
    }
    @Override
    public Catalog updateCatalogWithNewAttribute(Long id, Attribute attribute) {
        Catalog catalog = getCatalog(id);
        if (catalog.getAttribute() == null) {
            catalog.setAttribute(new ArrayList<>());
        }
        catalog.getAttribute().add(attribute);
        return catalogRepository.save(catalog);
    }

    }
