package com.school.project.schooldbproject.branch.dto;


import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.branch.entity.Inventory;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;
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
        Branch branch = new Branch();
        branch.setId(branchId);

        Catalogue catalogue = new Catalogue();
        catalogue.setId(catalogueId);

        return Inventory.builder()
                .catalogue(catalogue)
                .branch(branch)
                .quantity(quantity)
                .build();
    }
}
