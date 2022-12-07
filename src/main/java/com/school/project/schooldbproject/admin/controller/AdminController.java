package com.school.project.schooldbproject.admin.controller;

import com.school.project.schooldbproject.admin.dto.SalesDto.BranchSalesDto;
import com.school.project.schooldbproject.admin.dto.SalesDto.CatalogueSalesDto;
import com.school.project.schooldbproject.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("admin/sales/branches")
    @ResponseBody
    public List<BranchSalesDto> getBranchesSales(
            @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(name = "begin") Date begin,
            @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(name = "end") Date end) {
        return adminService.getBranchesSales(begin, end);
    }

    @GetMapping("admin/sales/catalogues")
    @ResponseBody
    public List<CatalogueSalesDto> getCataloguesSales(
            @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(name = "begin") Date begin,
            @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(name = "end") Date end) {
        return adminService.getCataloguesSales(begin, end);
    }

}
