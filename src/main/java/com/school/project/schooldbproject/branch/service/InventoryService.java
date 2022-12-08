package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.CreateInventoryDto;
import com.school.project.schooldbproject.branch.dto.InventoryDto;

import java.util.List;

public interface InventoryService {
    InventoryDto.Response addStock(CreateInventoryDto createInventoryDto);

    List<InventoryDto.FetchedResult> findByBranchId(Long branchId);
}
