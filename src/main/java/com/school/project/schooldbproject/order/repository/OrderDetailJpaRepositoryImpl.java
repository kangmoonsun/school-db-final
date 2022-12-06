package com.school.project.schooldbproject.order.repository;

import com.school.project.schooldbproject.order.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
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

//    @Override
//    public Optional<List<OrderDetail>> findByIds(List<CreateOrderDetailDto> createOrderDetailDtos) {
//        em.createQuery("select items from OrderDetail items where items.", OrderDetail.class)
//
//        return Optional.empty();
//    }
}
