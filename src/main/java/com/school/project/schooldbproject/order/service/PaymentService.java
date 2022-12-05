package com.school.project.schooldbproject.order.service;

import com.school.project.schooldbproject.order.dto.CreatePaymentDto;
import com.school.project.schooldbproject.order.entity.Payment;

public interface PaymentService {
    Payment createPayment(CreatePaymentDto createPaymentDto);
}
