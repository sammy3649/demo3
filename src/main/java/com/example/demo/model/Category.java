package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "category")
public class Category {

    @Id
    @Field("_id")
    private Integer id;

    @Field(value = "categoryName")
    private String categoryName;

    private Integer catalogId;

}
