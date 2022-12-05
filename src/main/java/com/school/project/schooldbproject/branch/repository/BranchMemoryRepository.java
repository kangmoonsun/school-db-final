package com.school.project.schooldbproject.branch.repository;

import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.user.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@Repository
public class BranchMemoryRepository implements BranchRepository {
    private static final Map<Long, Branch> memoryDataSource = new HashMap<>();
    private static Long sequence = 0L;


    @Override
    public Branch save(Branch branch) {
        branch.setId(++sequence);
        memoryDataSource.put(branch.getId(), branch);
        return branch;
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return Optional.ofNullable(memoryDataSource.get(id));
    }

    @Override
    public Optional<Branch> findByName(String name) {
        return memoryDataSource.values().stream()
                .filter((branch -> branch.getName().equals(name)))
                .findAny();
    }

    @Override
    public Optional<Branch> findByUser(User user) {
        return Optional.empty();
    }
}
