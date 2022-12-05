package com.school.project.schooldbproject.branch.repository;

import com.school.project.schooldbproject.branch.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class BranchJpaRepository implements BranchRepository {
    private final EntityManager em;

    @Autowired
    public BranchJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Branch save(Branch branch) {
        em.persist(branch);
        return branch;
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Branch> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Branch> findByUserId(Long id) {
        return Optional.empty();
    }
}
