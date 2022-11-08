package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS, property="_classCatalog")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Category.class),
//})
@Getter
@Setter
//@JsonIgnoreProperties
@Document(collection = "catalog")
public class Catalog {

    @Id
    @Field("_id")
    private Long id;

    @Field(value = "name")
    private String name;
    @DBRef(db = "category")
    private List<Category> categories ;
    @JsonIgnore
    private List<Attribute> attribute;

}
