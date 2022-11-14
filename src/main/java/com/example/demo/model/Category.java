package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

//@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS, property="_classCategory")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Product.class),
//})
@Getter
@Setter
@Document(collection = "category")
public class Category {

    @Id
    @Field("_id")
    private Long categoryId;

    @Field(value = "categoryName")
    private String categoryName;
    private Integer catalogId;
    @DBRef(db = "product")
    private List<Product> products;
    @JsonIgnore
    private List<Attribute> attribute;

}
