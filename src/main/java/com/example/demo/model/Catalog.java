package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
public class Catalog {
    @Id
    private Integer id;
    @Indexed
    @Field(value = "name")
    private String name;
    @Lob
    @Field(value = "creationDate")
    private final Date creationDate = new Date();
//    @Field(value = "Categories")
//    private List<Category> categories;

}