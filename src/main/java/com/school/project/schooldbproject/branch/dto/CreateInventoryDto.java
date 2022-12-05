package com.school.project.schooldbproject.branch.dto;


import com.school.project.schooldbproject.branch.entity.Inventory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateInventoryDto {
    @NotNull
    private Long catalogueId;

    @NotNull
    private Long branchId;

    @NotNull
    private Long quantity;

    public Inventory toEntity() {
        return Inventory.builder()
                .catalogueId(catalogueId)
                .branchId(branchId)
                .quantity(quantity)
                .build();
    }
}
