package com.school.project.schooldbproject.order.repository;

import com.school.project.schooldbproject.order.entity.OrderDetail;

import java.util.Optional;

public interface OrderDetailRepository {
    OrderDetail save(OrderDetail catalogue);

    Optional<OrderDetail> findById(Long id);
}
