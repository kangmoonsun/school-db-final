package com.school.project.schooldbproject.catalogue.service;

import com.school.project.schooldbproject.catalogue.dto.CatalogueDto;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import com.school.project.schooldbproject.catalogue.repository.CatalogueRepository;
import com.school.project.schooldbproject.global.error.exception.BusinessException;
import com.school.project.schooldbproject.global.error.exception.EntityNotFoundException;
import com.school.project.schooldbproject.global.error.exception.ErrorCode;
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
    public CatalogueDto.Response createCatalogue(CatalogueDto.CreateDto createCatalogueDto) {
        catalogueRepository.findByName(createCatalogueDto.getName())
                .ifPresent((item) -> {
                    throw new BusinessException("이미 존재하는 상품 입니다. 상품 이름: " + createCatalogueDto.getName(), ErrorCode.INVALID_INPUT_VALUE);
                });

        Catalogue catalogue = catalogueRepository.save(createCatalogueDto.toEntity());
        return new CatalogueDto.Response(catalogue);
    }

    @Override
    public CatalogueDto.Response findCatalogueById(Long id) {
        Catalogue catalogue = catalogueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("카탈로그 ID로 조회 실패. 이름: " + id));

        return new CatalogueDto.Response(catalogue);
    }

    @Override
    public CatalogueDto.Response findCatalogueByName(String name) {
        Catalogue catalogue = catalogueRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("카탈로그 이름으로 조회 실패. 이름: " + name));

        return new CatalogueDto.Response(catalogue);
    }
}
