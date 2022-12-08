package com.school.project.schooldbproject.catalogue.service;

import com.school.project.schooldbproject.catalogue.dto.CatalogueDto;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;

import java.util.List;

public interface CatalogueService {
    CatalogueDto.Response createCatalogue(CatalogueDto.CreateDto createCatalogueDto);

    CatalogueDto.Response findCatalogueById(Long id);

    CatalogueDto.Response findCatalogueByName(String name);

    List<Catalogue> findAll();


}
