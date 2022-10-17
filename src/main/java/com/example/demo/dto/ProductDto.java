package com.example.demo.dto;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ProductDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Category category;
}
