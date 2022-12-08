package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.CreateInventoryDto;
import com.school.project.schooldbproject.branch.dto.InventoryDto;
import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.branch.entity.Inventory;
import com.school.project.schooldbproject.branch.repository.BranchRepository;
import com.school.project.schooldbproject.branch.repository.InventoryRepository;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import com.school.project.schooldbproject.catalogue.repository.CatalogueRepository;
import com.school.project.schooldbproject.catalogue.service.CatalogueService;
import com.school.project.schooldbproject.global.error.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final CatalogueRepository catalogueRepository;
    private final BranchRepository branchRepository;


    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository, CatalogueService catalogueService, CatalogueRepository catalogueRepository, BranchRepository branchRepository) {
        this.inventoryRepository = inventoryRepository;
        this.catalogueRepository = catalogueRepository;
        this.branchRepository = branchRepository;
    }

    @Transactional
    @Override
    public InventoryDto.Response addStock(CreateInventoryDto createInventoryDto) {
        Optional<Inventory> inventoryOptional =
                inventoryRepository.findByIds(createInventoryDto.getBranchId(), createInventoryDto.getCatalogueId());

        if (inventoryOptional.isPresent()) {
            Inventory stock = inventoryOptional.get();
            stock.addStock(createInventoryDto.getQuantity());
            return new InventoryDto.Response(stock);
        }


        Inventory newStock = createStock(createInventoryDto);
        return new InventoryDto.Response(newStock);
    }

    private Inventory createStock(CreateInventoryDto createInventoryDto) {
        Branch branch = branchRepository.findById(createInventoryDto.getBranchId())
                .orElseThrow(() -> new EntityNotFoundException("재고 생성중 문제. 브랜치를 찾을 수 없습니다. 브랜치 ID: " + createInventoryDto.getBranchId()));
        
        Catalogue catalogue = catalogueRepository.findById(createInventoryDto.getCatalogueId())
                .orElseThrow(() -> new EntityNotFoundException("재고 생성중 문제. 카탈로그를 찾을 수 없습니다. 카탈로그 ID: " + createInventoryDto.getCatalogueId()));

        return inventoryRepository.save(createInventoryDto.createStock(branch, catalogue));
    }

    @Override
    public List<InventoryDto.FetchedResult> findByBranchId(Long branchId) {
        List<Inventory> inventories = inventoryRepository.findByBranchId(branchId)
                .orElseThrow(() -> new EntityNotFoundException("해당 브랜치 ID로 재고를 찾을 수 없습니다. 브랜치 ID: " + branchId));

        return inventories
                .stream()
                .map(InventoryDto.FetchedResult::new)
                .collect(Collectors.toList());
    }
}
