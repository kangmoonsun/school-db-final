package com.school.project.schooldbproject.order.repository;

import com.school.project.schooldbproject.order.entity.Payment;

import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);

    Optional<Payment> findById(Long id);
}
