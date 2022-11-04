package com.example.demo.service;

import com.example.demo.model.Attribute;

import java.util.List;

public interface AttributeService {
    Attribute createAttribute(Attribute attribute);

    Attribute getAttribute(Long id);

    Attribute deleteAttribute(Long id);

    Attribute deleteByName(String name);

    Attribute updateAttribute(Attribute attribute);

    Attribute findByName(String name);
}
