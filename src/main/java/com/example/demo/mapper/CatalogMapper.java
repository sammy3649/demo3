package com.example.demo.mapper;

import com.example.demo.dto.CatalogDto;
import com.example.demo.model.Catalog;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

 CatalogDto catalogToCatalogDto(Catalog catalog);
}
