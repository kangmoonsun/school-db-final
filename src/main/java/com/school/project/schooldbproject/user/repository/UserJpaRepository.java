package com.school.project.schooldbproject.user.repository;

import com.school.project.schooldbproject.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Primary
@Repository
public class UserJpaRepository implements UserRepository {

    private final EntityManager em;

    @Autowired
    public UserJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findOneById(Long id) {
        User foundUser = em.find(User.class, id);
        return Optional.ofNullable(foundUser);
    }
}
