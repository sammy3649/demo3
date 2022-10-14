package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Document(collection = "catalog")
public class Catalog {

    @Id
    @Field("_id")
    private Integer id;

    @Field(value = "name")
    private String name;

    @DBRef(db = "category")
    private List<Category> categories;

}
