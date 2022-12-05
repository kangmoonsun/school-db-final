package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.CreateInventoryDto;
import com.school.project.schooldbproject.branch.entity.Inventory;

public interface InventoryService {
    Inventory createInventory(CreateInventoryDto createInventoryDto);
}
