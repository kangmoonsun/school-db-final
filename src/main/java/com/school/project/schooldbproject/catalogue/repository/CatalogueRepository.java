package com.school.project.schooldbproject.catalogue.repository;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;

import java.util.Optional;

public interface CatalogueRepository {
    Catalogue save(Catalogue catalogue);

    Optional<Catalogue> findById(Long id);

    Optional<Catalogue> findByName(String name);
}
