package com.example.demo.service.impl;

import com.example.demo.model.Catalog;
import com.example.demo.repository.CatalogRepository;
import com.example.demo.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {
    private final MongoTemplate mongoTemplate;
    private final CatalogRepository catalogRepository;
    private static final String SOURCE_URL = "http://127.0.0.1:8080/";
    private static final Logger log = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository, MongoTemplate mongoTemplate) {
        this.catalogRepository = catalogRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Catalog createCatalog(Catalog catalog) {
        log.info("Was invoked method for create catalog {}", catalog);
        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog getCatalog(Integer id) {
        log.info("Was invoked method to get catalog {}", id);
        return catalogRepository.findById(id).get();
    }

    @Override
    public Catalog deleteCatalog(Integer id) {
        log.info("Was invoked method for delete catalog {}", id);
        catalogRepository.deleteById(id);
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
}
