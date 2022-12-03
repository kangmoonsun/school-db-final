package com.school.project.schooldbproject.catalogue.repository;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class CatalogueMemoryRepository implements CatalogueRepository {
    private static final Map<Long, Catalogue> memoryDataSource = new HashMap<>();
    private static Long sequence = 0L;


    @Override
    public Catalogue save(Catalogue catalogue) {
        catalogue.setId(++sequence);
        memoryDataSource.put(catalogue.getId(), catalogue);
        return catalogue;
    }

    @Override
    public Optional<Catalogue> findById(Long id) {
        return Optional.ofNullable(memoryDataSource.get(id));
    }

    @Override
    public Optional<Catalogue> findByName(String name) {
        return memoryDataSource.values()
                .stream()
                .filter((catalogue) -> catalogue.getName().equals(name))
                .findAny();
    }

}
