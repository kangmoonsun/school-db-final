package com.school.project.schooldbproject.branch.repository;

import com.school.project.schooldbproject.branch.entity.Branch;

import java.util.Optional;

public interface BranchRepository {
    Branch save(Branch branch);

    Optional<Branch> findById(Long id);

    Optional<Branch> findByName(String name);

    Optional<Branch> findByUserId(Long id);
}
