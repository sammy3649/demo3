package com.example.demo.repository;

import com.example.demo.model.Attribute;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    @Query("{'name' : {$regex: ?0, $options: 'i'}}")
    List<Product> findProductByName(String name);

    List<Product> deleteProductByProductId(Long productId);

    @Query("{'name' : {$regex: ?0, $options: 'i'}}")
    List<Product> deleteProductByName(String name);

    @Query("{'category' : {$regex: ?0, $options: 'i'}}")
    List<Product> findProductByCategory(Category category);


}
