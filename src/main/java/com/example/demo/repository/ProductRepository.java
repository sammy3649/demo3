package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product,Long> {
    @Query("{'name' : {$regex: ?0, $options: 'i'}}")
    Product findProductByName(String name);

    Optional<Product> findProductById(Long id);

    List<Product> deleteProductById(Long id);

    @Query("{'name' : {$regex: ?0, $options: 'i'}}")
    List<Product> deleteProductByName(String name);
    @Query("{'name' : {$regex: ?0, $options: 'i'}}")
    List<Product> findProductByCategory(Category category);


}
