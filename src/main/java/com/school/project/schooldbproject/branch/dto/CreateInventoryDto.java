package com.school.project.schooldbproject.branch.dto;


import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.branch.entity.Inventory;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Builder
public class CreateInventoryDto {
    @NotNull
    private Long catalogueId;

    @NotNull
    private Long branchId;

    @NotNull
    private Long quantity;

    public Inventory createStock(Branch branch, Catalogue catalogue) {
        return Inventory.builder()
                .branch(branch)
                .catalogue(catalogue)
                .stock(quantity)
                .createdAt(new Date())
                .build();
    }


    public Inventory toEntity() {
        Branch branch = new Branch();
        branch.setId(branchId);

        Catalogue catalogue = new Catalogue();
        catalogue.setId(catalogueId);

        return Inventory.builder()
                .catalogue(catalogue)
                .branch(branch)
                .stock(quantity)
                .createdAt(new Date())
                .build();
    }
}
