package com.school.project.schooldbproject.branch.service;

import com.school.project.schooldbproject.branch.dto.CreateBranchDto;
import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.branch.repository.BranchRepository;
import com.school.project.schooldbproject.global.error.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch createBranch(CreateBranchDto createBranchDto) {
        Branch branch = createBranchDto.toEntity();
        return branchRepository.save(branch);
    }

    @Override
    public Branch findBranchByName(String name) {
        Branch branch = branchRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("브랜치 이름으로 조회 실패. 이름: " + name));

        return branch;
    }
}
