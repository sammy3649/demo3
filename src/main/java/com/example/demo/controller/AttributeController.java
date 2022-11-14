package com.example.demo.controller;

import com.example.demo.model.Attribute;
import com.example.demo.repository.AttributeRepository;
import com.example.demo.service.AttributeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
    private final AttributeService attributeService;
    private final AttributeRepository attributeRepository;

    public AttributeController(AttributeService attributeService, AttributeRepository attributeRepository) {
        this.attributeService = attributeService;
        this.attributeRepository = attributeRepository;
    }

    @PostMapping
    public ResponseEntity<Attribute> addAttribute(@RequestBody Attribute attribute) {
        Attribute newAttribute = attributeService.createAttribute(attribute);
        return ResponseEntity.ok(newAttribute);
    }

    @GetMapping("{attrId}")
    public ResponseEntity<Attribute> getAttribute(@PathVariable Long attrId) {
        Attribute attribute = attributeService.getAttribute(attrId);
        return ResponseEntity.ok(attribute);
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<Attribute> getByName(@PathVariable String name) {
        Attribute attributeName = attributeRepository.findByName(name);
        if (attributeName == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(attributeName);

    }

    @PutMapping
    public ResponseEntity<Attribute> updateAttribute(@RequestBody Attribute attribute) {
        Attribute putAttribute = attributeService.updateAttribute(attribute);
        if (putAttribute == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(putAttribute);

    }

    @DeleteMapping("{attrId}")
    public ResponseEntity<Attribute> deleteAttribute(@PathVariable Long attrId) {
        Attribute deleteAttribute = attributeService.deleteAttribute(attrId);
        if (deleteAttribute == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(deleteAttribute);
    }

    @DeleteMapping(params = {"name"})
    public Attribute deleteByName(String name) {
        return attributeService.deleteByName(name);
    }


    @GetMapping("/allattributes")
    public List<Attribute> getAllProducts() {
        return attributeRepository.findAll();
    }

}
