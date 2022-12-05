package com.school.project.schooldbproject.user.service;

import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.branch.repository.BranchRepository;
import com.school.project.schooldbproject.global.error.exception.EntityNotFoundException;
import com.school.project.schooldbproject.user.dto.CreateUserDto;
import com.school.project.schooldbproject.user.dto.LoginDto;
import com.school.project.schooldbproject.user.dto.LoginSuccessResponse;
import com.school.project.schooldbproject.user.entity.User;
import com.school.project.schooldbproject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BranchRepository branchRepository) {
        this.userRepository = userRepository;
        this.branchRepository = branchRepository;
    }


    public LoginSuccessResponse login(LoginDto loginDto) {
        User foundUser = userRepository.findOneByEmail(loginDto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다. 이메일: " + loginDto.getEmail()));

        boolean isCorrect = foundUser.getPassword().equals(loginDto.getPassword());
        if (!isCorrect) {
            throw new EntityNotFoundException("사용자를 찾을 수 없습니다.");
        }

        Branch foundBranch = branchRepository.findByUserId(foundUser.getId())
                .orElseThrow(() -> new EntityNotFoundException("브랜치를 찾을 수 없습니다. 사용자 ID: " + foundUser.getId()));

        return LoginSuccessResponse.builder()
                .branchId(foundBranch.getId())
                .build();
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
