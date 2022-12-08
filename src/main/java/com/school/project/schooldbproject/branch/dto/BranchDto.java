package com.school.project.schooldbproject.branch.dto;

import com.school.project.schooldbproject.branch.entity.Branch;
import lombok.Getter;

public class BranchDto {

    @Getter
    public static class Response {
        private Long id;
        private String name;

        public Response(Branch entity) {
            this.id = entity.getId();
            this.name = entity.getName();
        }
    }
}
