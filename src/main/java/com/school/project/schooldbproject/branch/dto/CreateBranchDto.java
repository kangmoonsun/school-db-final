package com.school.project.schooldbproject.branch.dto;

import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.user.entity.User;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateBranchDto {
    @NotNull
    private String name;

    @NotNull
    private Long userId;

    public Branch toEntity() {
        User user = new User();
        user.setId(userId);

        return Branch.builder()
                .name(name)
                .owner(user)
                .build();
    }
}
