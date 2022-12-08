package com.school.project.schooldbproject.branch.dto;

import com.school.project.schooldbproject.branch.entity.Inventory;
import com.school.project.schooldbproject.catalogue.dto.CatalogueDto;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class InventoryDto {

    @Getter
    public static class Response {
        private Long id;
        private Long stock;
        private Date createdAt;
        private BranchDto.Response branch;
        private CatalogueDto.Response catalogue;


        public Response(Inventory entity) {
            this.id = entity.getId();
            this.stock = entity.getStock();
            this.createdAt = entity.getCreatedAt();
            this.branch = new BranchDto.Response(entity.getBranch());
            this.catalogue = new CatalogueDto.Response(entity.getCatalogue());
        }
    }


    @Setter
    @Getter
    public static class FetchedResult {
        private Long catalogueId;
        private String name;
        private Long price;
        private Long stock;

        public FetchedResult(Inventory entity) {
            Catalogue catalogue = entity.getCatalogue();

            this.catalogueId = catalogue.getId();
            this.name = catalogue.getName();
            this.price = catalogue.getPrice();
            this.stock = entity.getStock();
        }
    }
}
