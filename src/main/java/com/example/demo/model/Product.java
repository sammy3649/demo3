package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@Document(collection = "product")
public class Product {

    @Id
    private Integer id;

    @Field(value = "name")
    private String name;

    @Field(value = "description")
    private String description;

}
