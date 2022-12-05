package com.school.project.schooldbproject.branch.repository;

import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class BranchJpaRepositoryImpl implements BranchRepository {
    private final EntityManager em;

    @Autowired
    public BranchJpaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Branch save(Branch branch) {
        em.persist(branch);
        return branch;
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return Optional.ofNullable(em.find(Branch.class, id));
    }

    @Override
    public Optional<Branch> findByName(String name) {
        return Optional.ofNullable(
                em.createQuery("select branch from Branch branch where branch.name = :name", Branch.class)
                        .setParameter("name", name)
                        .getSingleResult()
        );
    }

    @Override
    public Optional<Branch> findByUser(User user) {
        return Optional.ofNullable(
                em.createQuery("select branch from Branch branch where branch.owner = :user", Branch.class)
                        .setParameter("user", user)
                        .getSingleResult()
        );
    }

}
