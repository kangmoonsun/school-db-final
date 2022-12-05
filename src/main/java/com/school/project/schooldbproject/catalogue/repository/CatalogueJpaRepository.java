package com.school.project.schooldbproject.catalogue.repository;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CatalogueJpaRepository implements CatalogueRepository {
    private final EntityManager em;

    @Autowired
    public CatalogueJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Catalogue save(Catalogue catalogue) {
        em.persist(catalogue);
        return catalogue;
    }

    @Override
    public Optional<Catalogue> findById(Long id) {
        return Optional.ofNullable(em.find(Catalogue.class, id));
    }

    @Override
    public Optional<Catalogue> findByName(String name) {
        return Optional.ofNullable(
                em.createQuery("select catalogue from Catalogue catalogue where catalogue.name = :name", Catalogue.class)
                        .setParameter("name", name)
                        .getSingleResult()
        );

    }
}
