package com.school.project.schooldbproject.user.repository;

import com.school.project.schooldbproject.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Primary
@Transactional
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

    @Override
    public Optional<User> findOneByEmail(String email) {
        return em.createQuery("select user from User user where user.email = :email", User.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findAny();
    }

}
