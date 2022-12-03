package com.school.project.schooldbproject.user.repository;

import com.school.project.schooldbproject.user.entity.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findOneById(Long id);
}
