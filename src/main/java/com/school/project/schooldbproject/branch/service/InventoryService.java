package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.CreateInventoryDto;
import com.school.project.schooldbproject.branch.dto.FetchedInventoryDto;
import com.school.project.schooldbproject.branch.entity.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory createInventoryItem(CreateInventoryDto createInventoryDto);

    List<FetchedInventoryDto> findByBranchId(Long branchId);
}
