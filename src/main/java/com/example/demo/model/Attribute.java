package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Document(collection = "Attribute")
public class Attribute {
    @Id
    @Field("_id")
    public Long id;
    @Field(value = "name")
    public String name;
    @Field(value = "type")
    public String type;
    // @ReadOnlyProperty
   // @DocumentReference(lookup = "{'product':?#{#self._id} }")
//    List<Product> products;
//    @ReadOnlyProperty
//    @DocumentReference(lookup = "{'catalog':?#{#self._id} }")
//    List<Catalog> catalogs;
//    @ReadOnlyProperty
//    @DocumentReference(lookup = "{'category':?#{#self._id} }")
//    List<Category> categories;
}
