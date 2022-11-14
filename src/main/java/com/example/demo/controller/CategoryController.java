package com.example.demo.controller;

import com.example.demo.model.Attribute;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        productRepository.saveAll(category.getProducts());
        return ResponseEntity.ok().build();
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable Long categoryId) {
        Category category = categoryService.getCategory(categoryId);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(category);

    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category putCategory = categoryService.updateCategory(category);
        if (putCategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putCategory);

    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long categoryId) {
        Category deleteCategory = categoryService.deleteCategory(categoryId);
        if (deleteCategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deleteCategory);
    }

    @DeleteMapping(params = {"name"})
    public Category deleteByName(
            @RequestParam(required = false) String categoryName) {
        return categoryService.deleteCategoryByName(categoryName);
    }

    @GetMapping(params = {"categoryName"})
    public List<Category> findByCategoryName(@RequestParam(required = false) String categoryName) {
        return categoryService.findByCategoryName(categoryName);
    }

    @GetMapping("/startwith")
    public List<String> getCategoryNameStartWithA(String letter) {
        return categoryService.getCategoryNameStartWith(letter);
    }

    @GetMapping("/allcategories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/{categoryId}/add-attribute")
    public ResponseEntity<Category> updateNewCategory(@PathVariable Long categoryId, @RequestBody Attribute attribute) {
        Category putNewCategory = categoryService.updateCategoryWithNewAttribute(categoryId, attribute);
        if (putNewCategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putNewCategory);
    }

    @DeleteMapping("/{categoryId}/delete-attribute")
    public ResponseEntity<Category> removeAttributeInCategory(@PathVariable Long categoryId, @RequestBody Attribute attribute) {
        Category deletedCategory = categoryService.deleteAttributeInCategory(categoryId, attribute);
        if (deletedCategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deletedCategory);
    }
}

