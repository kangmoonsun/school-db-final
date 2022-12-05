package com.school.project.schooldbproject.branch.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInventoryDto {
    private Long catalogueId;
    private Long branchId;
    private Long quantity;
}
