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


    public User toEntity() {
        return User.builder()
                .name(name)
                .build();
    }
}
