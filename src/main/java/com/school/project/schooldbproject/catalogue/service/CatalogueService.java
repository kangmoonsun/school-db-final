package com.school.project.schooldbproject.catalogue.service;

import com.school.project.schooldbproject.catalogue.dto.CatalogueDto;

public interface CatalogueService {
    CatalogueDto.Response createCatalogue(CatalogueDto.CreateDto createCatalogueDto);

    CatalogueDto.Response findCatalogueById(Long id);

    CatalogueDto.Response findCatalogueByName(String name);
}
