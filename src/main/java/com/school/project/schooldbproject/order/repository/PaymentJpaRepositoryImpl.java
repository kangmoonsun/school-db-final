package com.school.project.schooldbproject.order.repository;

import com.school.project.schooldbproject.order.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class PaymentJpaRepositoryImpl implements PaymentRepository {
    private final EntityManager em;

    @Autowired
    public PaymentJpaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Payment save(Payment payment) {
        em.persist(payment);
        return payment;
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return Optional.ofNullable(em.find(Payment.class, id));
    }

    @Override
    public Optional<List<Payment>> findAllByBranchId(Long branchId) {
        return Optional.ofNullable(
                em.createQuery("select payment from Payment payment where payment.branch.id = :branchId", Payment.class)
                        .setParameter("branchId", branchId)
                        .getResultList()
        );
    }
}
