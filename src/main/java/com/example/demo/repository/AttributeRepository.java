package com.example.demo.repository;

import com.example.demo.model.Attribute;
import com.example.demo.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttributeRepository extends MongoRepository<Attribute, String> {
    @Query("{'categoryName' : {$regex: ?0, $options: 'i'}}")
    List<Attribute> deleteByName(String name);

    @Query("{'name' : {$regex: ?0, $options: 'i'}}")
    Attribute findByName(String name);

    Optional<Attribute> findById(Long id);

    List<Attribute> deleteById(Long id);

    List<Attribute> getById(Long id);

}
