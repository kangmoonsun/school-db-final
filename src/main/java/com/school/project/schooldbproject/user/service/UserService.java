package com.school.project.schooldbproject.user.service;

import com.school.project.schooldbproject.user.dto.CreateUserDto;
import com.school.project.schooldbproject.user.dto.LoginDto;
import com.school.project.schooldbproject.user.dto.UserDto;
import com.school.project.schooldbproject.user.entity.User;

public interface UserService {

    UserDto.Response createUser(CreateUserDto createUserDto);

    User findOneUserById(Long id);

    UserDto.Response login(LoginDto loginDto);
}
