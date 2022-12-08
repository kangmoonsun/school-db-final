package com.school.project.schooldbproject.user.dto;

import com.school.project.schooldbproject.branch.dto.BranchDto;
import com.school.project.schooldbproject.user.entity.User;
import lombok.Getter;

public class UserDto {

    @Getter
    public static class Response {
        private Long id;
        private String email;
        private String role;
        private BranchDto.Response branch;

        public Response(User entity) {
            this.id = entity.getId();
            this.email = entity.getEmail();
            this.role = entity.getRole();
            this.branch = new BranchDto.Response(entity.getBranch());
        }
    }
}
