package com.school.project.schooldbproject.user.repository;

import com.school.project.schooldbproject.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserMemoryRepositoryImpl implements UserRepository {
    private static final Map<Long, User> memoryDataSource = new HashMap<>();
    private static Long sequence = 0L;


    @Override
    public User save(User user) {
        user.setId(++sequence);
        memoryDataSource.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findOneById(Long id) {
        User foundUser = memoryDataSource.get(id);
        return Optional.ofNullable(foundUser);
    }
}
