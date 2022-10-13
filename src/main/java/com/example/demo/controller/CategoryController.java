package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategory(@PathVariable long id) {
        Category category = categoryService.getCategory(id);
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

    @DeleteMapping("{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable long id) {
        Category deleteCategory = categoryService.deleteCategory(id);
        if (deleteCategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deleteCategory);
    }

    @DeleteMapping("{categoryName}")
    public ResponseEntity<Category> deleteCategoryByNAme(@PathVariable String categoryName) {
        Category deleteCategoryByName = categoryService.deleteCategoryByName(categoryName);
        if (deleteCategoryByName == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deleteCategoryByName);
    }

    @GetMapping(params = {"categoryName"})
    public List<Category> findByCategoryName(@RequestParam(required = false) String categoryName) {
        return categoryService.findByCategoryName(categoryName);
    }

    @GetMapping("/startwitha")
    public List<String> getCategoryNameStartWithA() {
        return categoryService.getCategoryNameStartWith();
    }
}

