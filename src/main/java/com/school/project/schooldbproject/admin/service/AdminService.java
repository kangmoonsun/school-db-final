package com.school.project.schooldbproject.admin.service;

import com.school.project.schooldbproject.admin.dto.SalesDto.CatalogueSalesDto;
import com.school.project.schooldbproject.admin.repository.AdminRepository;
import com.school.project.schooldbproject.global.error.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.school.project.schooldbproject.admin.dto.SalesDto.BranchSalesDto;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<BranchSalesDto> getBranchesSales(Date begin, Date end) {
        List<BranchSalesDto> branchSalesDtos = this.adminRepository.getBranchesSales(begin, end)
                .orElseThrow(() -> new EntityNotFoundException("요청한 날짜로 통계를 낼 수 없습니다. 요청한 날짜: begin - " + begin + ", end - " + end));

        return branchSalesDtos;
    }


    public List<CatalogueSalesDto> getCataloguesSales(Date begin, Date end) {
        List<CatalogueSalesDto> catalogueSalesDtos = this.adminRepository.getCataloguesSales(begin, end)
                .orElseThrow(() -> new EntityNotFoundException("요청한 날짜로 통계를 낼 수 없습니다. 요청한 날짜: begin - " + begin + ", end - " + end));

        return catalogueSalesDtos;
    }
}
