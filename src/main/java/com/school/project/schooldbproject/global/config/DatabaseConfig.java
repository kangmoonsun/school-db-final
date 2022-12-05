package com.school.project.schooldbproject.global.config;

import com.school.project.schooldbproject.branch.repository.BranchJpaRepository;
import com.school.project.schooldbproject.branch.repository.BranchRepository;
import com.school.project.schooldbproject.branch.repository.InventoryJpaRepository;
import com.school.project.schooldbproject.branch.repository.InventoryRepository;
import com.school.project.schooldbproject.catalogue.repository.CatalogueJpaRepository;
import com.school.project.schooldbproject.catalogue.repository.CatalogueRepository;
import com.school.project.schooldbproject.order.repository.OrderDetailJpaRepositoryImpl;
import com.school.project.schooldbproject.order.repository.OrderDetailRepository;
import com.school.project.schooldbproject.order.repository.PaymentJpaRepositoryImpl;
import com.school.project.schooldbproject.order.repository.PaymentRepository;
import com.school.project.schooldbproject.user.repository.UserJpaRepository;
import com.school.project.schooldbproject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class DatabaseConfig {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public DatabaseConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public CatalogueRepository catalogueRepository() {
        return new CatalogueJpaRepository(em);
    }


    @Bean
    public InventoryRepository inventoryRepository() {
        return new InventoryJpaRepository(em);
    }
    
    @Bean
    public BranchRepository branchJpaRepository() {
        return new BranchJpaRepository(em);
    }

    @Bean
    public OrderDetailRepository orderDetailRepository() {
        return new OrderDetailJpaRepositoryImpl(em);
    }

    @Bean
    public PaymentRepository paymentRepository() {
        return new PaymentJpaRepositoryImpl(em);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserJpaRepository(em);
//        return new UserMemoryRepositoryImpl();
    }
}
