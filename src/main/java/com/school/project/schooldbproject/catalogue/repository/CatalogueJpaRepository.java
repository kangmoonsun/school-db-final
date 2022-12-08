package com.school.project.schooldbproject.catalogue.repository;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
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
        return em.createQuery("select catalogue from Catalogue catalogue where catalogue.name = :name", Catalogue.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public Optional<List<Catalogue>> findByIds(List<Long> ids) {
        List<Catalogue> catalogues =
                em.createQuery("select items from Catalogue items where items.id in :ids", Catalogue.class)
                        .setParameter("ids", ids)
                        .getResultList();

        return Optional.ofNullable(catalogues);
    }

    @Override
    public Optional<List<Catalogue>> findAll() {
        return Optional.ofNullable(
                em.createQuery("select catalogue from Catalogue catalogue", Catalogue.class)
                        .getResultList()
        );
    }
}
