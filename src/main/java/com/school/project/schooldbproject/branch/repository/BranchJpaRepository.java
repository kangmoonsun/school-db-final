package com.school.project.schooldbproject.branch.repository;

import com.school.project.schooldbproject.branch.entity.Branch;

import java.util.Optional;

public class BranchJpaRepository implements BranchRepository {
    @Override
    public Branch save(Branch branch) {
        return null;
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Branch> findByName(String name) {
        return Optional.empty();
    }
}
