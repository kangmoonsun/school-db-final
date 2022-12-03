package com.school.project.schooldbproject.user.service;

import com.school.project.schooldbproject.user.dto.CreateUserDto;
import com.school.project.schooldbproject.user.entity.User;

public interface UserService {

    User createUser(CreateUserDto createUserDto);

    User findOneUserById(Long id);
}
