package com.school.project.schooldbproject.catalogue.dto;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
public class CreateCatalogueDto {
    @NotNull
    private String name;

    @NotNull
    private Long price;

    public Catalogue toEntity() {
        return Catalogue.builder()
                .name(name)
                .price(price)
                .build();
    }
}
