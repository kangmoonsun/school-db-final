package com.school.project.schooldbproject.admin.dto;


import com.school.project.schooldbproject.admin.entity.BranchSales;
import com.school.project.schooldbproject.admin.entity.CatalogueSales;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class SalesDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BranchSalesDto {
        private String name;
        private Long totalSales;

        public BranchSalesDto(BranchSales entity) {
            this.name = entity.getName();
            this.totalSales = entity.getTotalSales();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CatalogueSalesDto {
        private String name;
        private Long totalSales;

        public CatalogueSalesDto(CatalogueSales entity) {
            this.name = entity.getName();
            this.totalSales = entity.getTotalSales();
        }
    }
}
