package com.school.project.schooldbproject.branch.dto;

import com.school.project.schooldbproject.branch.entity.Branch;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateBranchDto {
    @NotNull
    private String name;

    @NotNull
    private Long userId;

    public Branch toEntity() {
        return Branch.builder()
                .name(name)
                .userId(userId)
                .build();
    }
}
