package com.school.project.schooldbproject.branch.repository;

import com.school.project.schooldbproject.branch.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
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

    @Override
    public void updateInventories(List<Inventory> inventories) {
        inventories.forEach(em::persist);
    }

    @Override
    public Optional<List<Inventory>> findByBranchId(Long branchId) {
        List<Inventory> inventories =
                em.createQuery("select items from Inventory items join fetch items.catalogue where items.branch.id = :branchId", Inventory.class)
                        .setParameter("branchId", branchId)
                        .getResultList();

        return Optional.ofNullable(inventories);

//        List<Inventory> inventories = em.createQuery("select items from Inventory items where items.branch.id = :branchId", Inventory.class)
//                .setParameter("branchId", branchId)
//                .getResultList();
//
//        return Optional.ofNullable(inventories);
    }


//        Branch branch = em.find(Branch.class, branchId);
//        return Optional.ofNullable(branch.getInventories()); }

}
