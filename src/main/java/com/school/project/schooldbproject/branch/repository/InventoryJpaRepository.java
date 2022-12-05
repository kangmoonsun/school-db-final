package com.school.project.schooldbproject.branch.repository;

import com.school.project.schooldbproject.branch.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class InventoryJpaRepository implements InventoryRepository {
    private final EntityManager em;

    @Autowired
    public InventoryJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Inventory save(Inventory inventory) {
        em.persist(inventory);
        return inventory;
    }

}
