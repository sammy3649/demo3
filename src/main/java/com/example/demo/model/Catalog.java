package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;
import java.util.*;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(Category.class)})
//        @JsonSubTypes.Type(Product.class)}
//)
@Document(collection = "catalog")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Catalog {
    @GeneratedValue
    @Id
    private Long id;
    @Indexed
    @Field(value = "name")
    private String name;
    @Lob
    @Field(value = "creationDate")
    private final Date creationDate = new Date();
    @JsonIgnore
    @Field(value = "categories")
    private Collection<Category> categories;

}