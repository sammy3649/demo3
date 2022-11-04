package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private static final String SOURCE_URL = "http://127.0.0.1:8080/";
    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        log.info("Was invoked method for create category in catalog {}", category);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategoryByName(String categoryName) {
        log.info("Was invoked method for get category in catalog {}", categoryName);
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public Category getCategory(Long id) {
        log.info("Was invoked method for get category in catalog {}", id);
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category deleteCategory(Long id) {
        log.info("Was invoked method for delete category in catalog {}", id);
        categoryRepository.deleteCategoryById(id);
        return null;
    }

    @Override
    public Category deleteCategoryByName(String categoryName) {
        log.info("Was invoked method for delete category in catalog {}", categoryName);
        categoryRepository.deleteByCategoryName(categoryName);
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        log.info("Was invoked method for update category in catalog {}", category);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findByCategoryName(String categoryName) {
        log.info("Was invoked method to find by category name in catalog {}", categoryName);
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public List<String> getCategoryNameStartWith(String letter) {
        log.info("Was invoked method to get category starting with ");
        return categoryRepository.findAll().stream().parallel()
                .map(Category::getCategoryName)
                .map(String::toUpperCase)
                .filter(a -> a.startsWith(String.valueOf(letter)))
                .sorted()
                .collect(Collectors.toList());
    }
    //@Override
    //public void getParentAttributes() {
      //  Field[] categoryFields = Category.class.getSuperclass().getDeclaredFields();
       // Field[] catalogFields = Category.class.getDeclaredFields();
        //Field[] allFields = new Field[catalogFields.length + catalogFields.length];
        //Arrays.setAll(allFields, i ->
          //      (i < catalogFields.length ? categoryFields[i] : categoryFields[i - catalogFields.length]));}

}
