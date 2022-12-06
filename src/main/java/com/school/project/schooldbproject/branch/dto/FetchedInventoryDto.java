package com.school.project.schooldbproject.branch.dto;

import com.school.project.schooldbproject.branch.entity.Inventory;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class FetchedInventoryDto {
    private Long catalogueId;
    private String name;
    private Long price;
    private Long stock;
//    private Inventory inventory;
//    private Catalogue catalogue;

    public static FetchedInventoryDto createDto(Inventory inventory) {
        Catalogue catalogue = inventory.getCatalogue();

        return FetchedInventoryDto.builder()
                .catalogueId(catalogue.getId())
                .name(catalogue.getName())
                .price(catalogue.getPrice())
                .stock(inventory.getStock())
                .build();
    }


}
