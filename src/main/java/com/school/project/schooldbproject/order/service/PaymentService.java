package com.school.project.schooldbproject.order.service;

import com.school.project.schooldbproject.order.dto.CreatePaymentDto;
import com.school.project.schooldbproject.order.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    PaymentDto.Response createPayment(CreatePaymentDto createPaymentDto);

    List<PaymentDto.Response> findPaymentsByBranchId(Long branchId);
}
