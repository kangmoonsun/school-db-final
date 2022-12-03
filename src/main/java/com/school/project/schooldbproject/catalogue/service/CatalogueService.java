package com.school.project.schooldbproject.catalogue.service;

import com.school.project.schooldbproject.catalogue.dto.CreateCatalogueDto;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;

public interface CatalogueService {
    Catalogue createCatalogue(CreateCatalogueDto createCatalogueDto);

    Catalogue findCatalogueById(Long id);

    Catalogue findCatalogueByName(String name);
}
