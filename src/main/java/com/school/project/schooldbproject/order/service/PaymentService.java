package com.school.project.schooldbproject.order.service;

import com.school.project.schooldbproject.order.dto.CreatePaymentDto;
import com.school.project.schooldbproject.order.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(CreatePaymentDto createPaymentDto);

    List<Payment> findPaymentsByBranchId(Long branchId);
}
