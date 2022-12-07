package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.CreateInventoryDto;
import com.school.project.schooldbproject.branch.dto.FetchedInventoryDto;
import com.school.project.schooldbproject.branch.entity.Inventory;
import com.school.project.schooldbproject.branch.repository.InventoryRepository;
import com.school.project.schooldbproject.global.error.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Optional<Inventory> inventoryOptional =
                inventoryRepository.findByIds(createInventoryDto.getBranchId(), createInventoryDto.getCatalogueId());

        if (inventoryOptional.isPresent()) {
            Inventory stock = inventoryOptional.get();
            stock.addStock(createInventoryDto.getQuantity());
            return stock;
        }


        Inventory newStock = createInventoryDto.toEntity();
        return inventoryRepository.save(newStock);
    }

    @Override
    public List<FetchedInventoryDto> findByBranchId(Long branchId) {
        List<Inventory> inventories = inventoryRepository.findByBranchId(branchId)
                .orElseThrow(() -> new EntityNotFoundException("해당 브랜치 ID로 재고를 찾을 수 없습니다. 브랜치 ID: " + branchId));

        return inventories
                .stream()
                .map(item -> FetchedInventoryDto.createDto(item))
                .collect(Collectors.toList());
    }
}
