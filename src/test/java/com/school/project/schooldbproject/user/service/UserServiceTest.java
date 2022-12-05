package com.school.project.schooldbproject.user.service;

import com.school.project.schooldbproject.user.dto.CreateUserDto;
import com.school.project.schooldbproject.user.entity.User;
import com.school.project.schooldbproject.user.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {
    UserService userService;
    UserRepository userRepository;

//    @BeforeEach
//    void beforeEach() {
//        userRepository = new UserMemoryRepositoryImpl();
//        userService = new UserServiceImpl(userRepository, branchRepository);
//    }

    @Test
    void 사용자_생성() {
        //given
        CreateUserDto createUserDto = CreateUserDto.builder()
                .name("JEE")
                .build();
        //when
        User savedUser = userService.createUser(createUserDto);


        //then
        assertThat(savedUser.getName()).isEqualTo("JEE");
    }
}
