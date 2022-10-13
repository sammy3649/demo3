package com.example.demo.service;

import com.example.demo.model.Catalog;

public interface CatalogService {
    Catalog createCatalog(Catalog catalog);

    Catalog getCatalog(Long id);

    Catalog deleteCatalog(Long id);

    Catalog updateCatalog(Catalog catalog);

    Catalog findByName(String name);

}
