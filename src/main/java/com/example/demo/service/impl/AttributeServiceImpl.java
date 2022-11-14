package com.example.demo.service.impl;

import com.example.demo.model.Attribute;
import com.example.demo.repository.AttributeRepository;
import com.example.demo.service.AttributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl implements AttributeService {
    private final AttributeRepository attributeRepository;
    private static final String SOURCE_URL = "http://127.0.0.1:8080/";
    private static final Logger log = LoggerFactory.getLogger(CatalogServiceImpl.class);

    public AttributeServiceImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @Override
    public Attribute createAttribute(Attribute attribute) {
        log.info("Was invoked method for create catalog {}", attribute);
        return attributeRepository.save(attribute);
    }

    @Override
    public Attribute getAttribute(Long attrId) {
        log.info("Was invoked method to get catalog {}", attrId);
        return attributeRepository.findByAttrId(attrId).get();
    }

    @Override
    public Attribute deleteAttribute(Long attrId) {
        log.info("Was invoked method for delete catalog {}", attrId);
        attributeRepository.deleteByAttrId(attrId);
        return null;
    }

    @Override
    public Attribute deleteByName(String name) {
        log.info("Was invoked method for delete catalog {}", name);
        attributeRepository.deleteByName(name);
        return null;
    }

    @Override
    public Attribute updateAttribute(Attribute attribute) {
        log.info("Was invoked method for update catalog {}", attribute);
        return attributeRepository.save(attribute);
    }

    @Override
    public Attribute findByName(String name) {
        log.info("Was invoked method to find by name {}", name);
        return attributeRepository.findByName(name);
    }
}
