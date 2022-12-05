package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.CreateInventoryDto;
import com.school.project.schooldbproject.branch.entity.Inventory;
import com.school.project.schooldbproject.branch.repository.InventoryRepository;
import com.school.project.schooldbproject.catalogue.repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository, CatalogueRepository catalogueRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory createInventoryItem(CreateInventoryDto createInventoryDto) {
        Inventory inventoryItem = createInventoryDto.toEntity();
        return inventoryRepository.save(inventoryItem);
    }
}
