package com.school.project.schooldbproject.branch.controller;

import com.school.project.schooldbproject.branch.dto.CreateBranchDto;
import com.school.project.schooldbproject.branch.dto.CreateInventoryDto;
import com.school.project.schooldbproject.branch.dto.FetchedInventoryDto;
import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.branch.entity.Inventory;
import com.school.project.schooldbproject.branch.service.BranchService;
import com.school.project.schooldbproject.branch.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BranchController {
    private final BranchService branchService;
    private final InventoryService inventoryService;

    @Autowired
    public BranchController(BranchService branchService, InventoryService inventoryService) {
        this.branchService = branchService;
        this.inventoryService = inventoryService;
    }

    @PostMapping("inventory")
    @ResponseBody
    Inventory createInventory(@RequestBody CreateInventoryDto createInventoryDto) {
        return inventoryService.createInventoryItem(createInventoryDto);
    }

    /**
     * 매장 ID로 재고 불러오는 API
     */
    @GetMapping("branch/{id}/inventories")
    @ResponseBody
    List<FetchedInventoryDto> getStocks(@PathVariable(name = "id") String branchId) {
        return inventoryService.findByBranchId(Long.valueOf(branchId));
    }

    /**
     * Todo: 새로운 매장 생성 API
     */
    @PostMapping("branch")
    @ResponseBody
    Branch createBranch(@RequestBody CreateBranchDto createBranchDto) {
        return branchService.createBranch(createBranchDto);
    }


    @GetMapping("branch/{id}")
    @ResponseBody
    Branch findBranchById(@PathVariable(name = "id") String branchId) {
        return branchService.findBranchById(Long.valueOf(branchId));
    }
}
