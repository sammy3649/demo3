package com.example.demo.repository;

import com.example.demo.model.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, Long> {

    @Query("{'name' : {$regex: ?0, $options: 'i'}}")
    Catalog findByName(String name);

    void deleteById(Long id);

    Optional<Catalog> findById(Long id);
}
