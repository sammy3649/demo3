package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Getter
@Setter
//@JsonIgnoreProperties
@Document(collection = "product")
public class Product  {

    @Id
    private Long id;
    @Field(value = "name")
    private String name;
    @Field(value = "description")
    private String description;
    @JsonIgnore
    private List<Attribute> attribute;

}
