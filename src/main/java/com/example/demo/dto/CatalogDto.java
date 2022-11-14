package com.example.demo.dto;


import com.example.demo.model.Category;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CatalogDto implements Serializable {
    private final String catalogId;
    private final String name;
    private Date creationDate = new Date();
    private List<Category> categories;
}
