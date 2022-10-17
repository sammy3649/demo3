package com.example.demo.service;

import com.example.demo.model.Catalog;

public interface CatalogService {
    Catalog createCatalog(Catalog catalog);

    Catalog getCatalog(Integer id);

    Catalog deleteCatalog(Integer id);

    Catalog updateCatalog(Catalog catalog);

    Catalog findByName(String name);

}
