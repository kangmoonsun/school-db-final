package com.school.project.schooldbproject.branch.controller;

import com.school.project.schooldbproject.branch.dto.CreateBranchDto;
import com.school.project.schooldbproject.branch.entity.Branch;
import com.school.project.schooldbproject.branch.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {
    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    /**
     * Todo: 새로운 매장 생성 API
     */
    @PostMapping("branch")
    @ResponseBody
    Branch createBranch(@RequestBody CreateBranchDto createBranchDto) {
        return branchService.createBranch(createBranchDto);
    }


}
