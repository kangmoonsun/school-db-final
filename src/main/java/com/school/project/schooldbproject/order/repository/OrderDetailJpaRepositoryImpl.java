package com.school.project.schooldbproject.order.repository;

import com.school.project.schooldbproject.order.entity.OrderDetail;

import java.util.Optional;

public class OrderDetailJpaRepositoryImpl implements OrderDetailRepository {
    @Override
    public OrderDetail save(OrderDetail catalogue) {
        return null;
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.empty();
    }
}
