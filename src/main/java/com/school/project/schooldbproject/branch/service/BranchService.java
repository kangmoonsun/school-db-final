package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.CreateBranchDto;
import com.school.project.schooldbproject.branch.entity.Branch;

public interface BranchService {
    Branch createBranch(CreateBranchDto createBranchDto);

    Branch findBranchById(final Long id);
}
