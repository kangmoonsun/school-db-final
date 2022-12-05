package com.school.project.schooldbproject.catalogue.service;

import com.school.project.schooldbproject.catalogue.dto.CreateCatalogueDto;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import com.school.project.schooldbproject.catalogue.repository.CatalogueRepository;
import com.school.project.schooldbproject.global.error.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CatalogueServiceImpl implements CatalogueService {
    private final CatalogueRepository catalogueRepository;

    @Autowired
    public CatalogueServiceImpl(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    @Override
    public Catalogue createCatalogue(CreateCatalogueDto createCatalogueDto) {
        Catalogue catalogue = createCatalogueDto.toEntity();
        return catalogueRepository.save(catalogue);
    }

    @Override
    public Catalogue findCatalogueById(Long id) {
        return catalogueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("카탈로그 ID로 조회 실패. 이름: " + id));
    }

    @Override
    public Catalogue findCatalogueByName(String name) {
        return catalogueRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("카탈로그 이름으로 조회 실패. 이름: " + name));
    }
}
