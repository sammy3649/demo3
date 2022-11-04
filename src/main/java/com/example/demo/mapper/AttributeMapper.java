package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Comment;

@Mapper
public interface AttributeMapper {

    AttributeMapper INSTANCE = Mappers.getMapper(AttributeMapper.class);

        @Mapping(source = "pk", target = "id")
        Attribute productToAttribute(Product product);

        @Mapping(source = "id", target = "pk")
        Product attributeToProduct(Comment comment);
    }

