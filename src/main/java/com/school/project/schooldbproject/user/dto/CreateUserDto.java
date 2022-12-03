package com.school.project.schooldbproject.user.dto;

import com.school.project.schooldbproject.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserDto {
    private String name;
    private String address;

    public User toEntity() {
        return User.builder()
                .name(name)
                .address(address)
                .build();
    }
}
