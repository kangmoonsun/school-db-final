package com.school.project.schooldbproject.global.config;

import org.springframework.beans.factory.annotation.Autowired;
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
//
//    @Bean
//    public CatalogueRepository catalogueRepository() {
//        return new CatalogueJpaRepository(em);
//    }
//
//
//    @Bean
//    public InventoryRepository inventoryRepository() {
//        return new InventoryJpaRepository(em);
//    }
//
//    @Bean
//    public BranchRepository branchJpaRepository() {
//        return new BranchJpaRepositoryImpl(em);
//    }
//
//    @Bean
//    public OrderDetailRepository orderDetailRepository() {
//        return new OrderDetailJpaRepositoryImpl(em);
//    }
//
//    @Bean
//    public PaymentRepository paymentRepository() {
//        return new PaymentJpaRepositoryImpl(em);
//    }
//
//    @Bean
//    public UserRepository userRepository() {
//        return new UserJpaRepository(em);
//        return new UserMemoryRepositoryImpl();
//    }
}
