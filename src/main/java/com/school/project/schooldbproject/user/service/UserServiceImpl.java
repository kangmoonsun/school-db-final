package com.school.project.schooldbproject.user.service;

import com.school.project.schooldbproject.global.error.exception.EntityNotFoundException;
import com.school.project.schooldbproject.user.dto.CreateUserDto;
import com.school.project.schooldbproject.user.entity.User;
import com.school.project.schooldbproject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(CreateUserDto createUserDto) {
        User user = createUserDto.toEntity();
        return userRepository.save(user);
    }

    @Override
    public User findOneUserById(Long id) {
        return userRepository.findOneById(id).orElseThrow(() -> new EntityNotFoundException("해당 ID로 사용자를 찾을 수 없음. ID: " + id));
    }

}
