package com.school.project.schooldbproject.branch.repository;

import com.school.project.schooldbproject.branch.entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository {
    Inventory save(Inventory inventory);

    void updateInventories(List<Inventory> inventories);

    Optional<Inventory> findById(Long id);

    Optional<Inventory> findByIds(Long branchId, Long catalogueId);

    Optional<List<Inventory>> findByBranchId(Long branchId);

}
