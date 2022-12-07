package com.school.project.schooldbproject.user.dto;

import com.school.project.schooldbproject.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class CreateUserDto {
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String branchName;

    /**
     * Todo: change to enum
     */
    @NotNull
    private String role;


    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }

}
