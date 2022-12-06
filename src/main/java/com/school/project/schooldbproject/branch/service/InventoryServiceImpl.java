package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.CreateInventoryDto;
import com.school.project.schooldbproject.branch.entity.Inventory;
import com.school.project.schooldbproject.branch.repository.InventoryRepository;
import com.school.project.schooldbproject.global.error.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory createInventoryItem(CreateInventoryDto createInventoryDto) {
        Inventory inventoryItem = createInventoryDto.toEntity();
        return inventoryRepository.save(inventoryItem);
    }

    @Override
    public List<Inventory> findByBranchId(Long branchId) {
        return inventoryRepository.findByBranchId(branchId)
                .orElseThrow(() -> new EntityNotFoundException("해당 브랜치 ID로 재고를 찾을 수 없습니다. 브랜치 ID: " + branchId));
    }

//    public List<Inventory> getInventoriesByCatalogueIds(List<Inventory> inventories, List<Long> catalogueIds) {
//        inventories.forEach();

//    }

}
