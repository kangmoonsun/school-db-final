package com.school.project.schooldbproject.order.repository;

import com.school.project.schooldbproject.order.entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrderDetailMemoryRepositoryImpl implements OrderDetailRepository {
    private static final Map<Long, OrderDetail> memoryDataSource = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        orderDetail.setId(++sequence);
        memoryDataSource.put(orderDetail.getId(), orderDetail);
        return orderDetail;
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.ofNullable(memoryDataSource.get(id));
    }
}
