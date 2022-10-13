package com.example.demo.repository;


import com.example.demo.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Long> {
    @Query("{'name' : {$regex: ?0, $options: 'i'}}")
    List<Category> findByCategoryName(String categoryName);

    Optional<Category> findById(Long id);

    List<Category> deleteCategoryById(Long id);

    @Query("{'name' : {$regex: ?0, $options: 'i'}}")
    List<Category> deleteByCategoryName(String categoryName);


}
