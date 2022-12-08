package com.school.project.schooldbproject.catalogue.dto;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class CatalogueDto {

    @Getter
    public static class Response {
        private Long id;
        private String name;
        private Long price;

        public Response(Catalogue entity) {
            this.id = entity.getId();
            this.name = entity.getName();
            this.price = entity.getPrice();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class CreateDto {
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
}
