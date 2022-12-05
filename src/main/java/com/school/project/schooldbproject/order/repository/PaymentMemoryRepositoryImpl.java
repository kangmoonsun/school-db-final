package com.school.project.schooldbproject.order.repository;

import com.school.project.schooldbproject.order.entity.Payment;

import java.util.Optional;

//@Repository
public class PaymentMemoryRepositoryImpl implements PaymentRepository {
    @Override
    public Payment save(Payment catalogue) {
        return null;
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return Optional.empty();
    }
}
