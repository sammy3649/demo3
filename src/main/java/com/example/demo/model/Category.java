package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonSerialize(using = ToStringSerializer.class)
@Document(collection = "category")
public class Category {
    @Id
    private Long id;
    @Indexed(unique = true)
    @Field(value = "categoryName")
    private String categoryName;
    @JsonIgnore
    @Field(value = "catalog")
    private Catalog catalog;
    @Field(value = "product")
    private List<Product> products;
    @Field(value = "categories")
    private List<Category> categories;

    public Category() {
    }

    public Category(Long id, String categoryName, Catalog catalog, List<Product> products, List<Category> categories) {
        this.categoryName = categoryName;
        this.catalog = catalog;
        this.products = products;
        this.categories = categories;
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(categoryName, category.categoryName) && Objects.equals(catalog, category.catalog) && Objects.equals(products, category.products) && Objects.equals(categories, category.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, catalog, products, categories);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", catalog=" + catalog +
                ", products=" + products +
                ", categories=" + categories +
                '}';
    }
}
