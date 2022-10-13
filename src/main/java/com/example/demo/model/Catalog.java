package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Lob;
import java.util.*;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
//@JsonSubTypes({
//        @JsonSubTypes.Type(Category.class),
//        @JsonSubTypes.Type(Product.class)}
//)
@Document(collection = "catalog")
public class Catalog {
    @Id
    private Long id;
    @Indexed(unique = true)
    @Field(value = "name")
    private String name;
    @Lob
    @Field(value = "creationDate")
    private final Date creationDate = new Date();
    @Field(value = "Categories")
    private List<Category> categories;

    public Catalog() {
    }

    public Catalog(Long id, String name, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
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
        Catalog catalog = (Catalog) o;
        return Objects.equals(id, catalog.id) && Objects.equals(name, catalog.name) && Objects.equals(creationDate, catalog.creationDate) && Objects.equals(categories, catalog.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, categories);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", categories=" + categories +
                '}';
    }
}