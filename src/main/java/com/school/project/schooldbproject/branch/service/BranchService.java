package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.BranchDto;
import com.school.project.schooldbproject.branch.dto.CreateBranchDto;

public interface BranchService {
    BranchDto.Response createBranch(CreateBranchDto createBranchDto);

    BranchDto.Response findBranchById(final Long id);
}
