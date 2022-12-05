package com.school.project.schooldbproject.user.controller;

import com.school.project.schooldbproject.user.dto.CreateUserDto;
import com.school.project.schooldbproject.user.dto.LoginDto;
import com.school.project.schooldbproject.user.dto.LoginSuccessResponse;
import com.school.project.schooldbproject.user.entity.User;
import com.school.project.schooldbproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 회원 가입 API
     */
    @PostMapping("user")
    @ResponseBody
    public User createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    @PostMapping("login")
    @ResponseBody
    public LoginSuccessResponse login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }
}
