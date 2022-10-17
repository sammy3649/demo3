package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonSerialize(using = ToStringSerializer.class)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "category")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Category {
    @Id
    private Integer id;
   @Indexed
    @Field(value = "categoryName")
    private String categoryName;
   // @JsonIgnore
  //  @Field(value = "catalog")
  //  private Catalog catalog;
    @Field(value = "product")
    private List<Product> products;
    @JsonIgnore
    @Field(value = "categories")
    private List<Category> categories;

    public Category(Integer id, String categoryName, List<Product> products, List<Category> categories) {
        this.id = id;
        this.categoryName = categoryName;
        this.products = products;
        this.categories = categories;
    }

    public Category() {
    }
}
