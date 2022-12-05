package com.school.project.schooldbproject.order.repository;

import com.school.project.schooldbproject.order.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class OrderDetailJpaRepositoryImpl implements OrderDetailRepository {

    private final EntityManager em;

    @Autowired
    public OrderDetailJpaRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public OrderDetail save(OrderDetail catalogue) {
        return null;
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.empty();
    }
}
