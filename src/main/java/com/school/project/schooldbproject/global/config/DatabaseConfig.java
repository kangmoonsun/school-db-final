package com.school.project.schooldbproject.global.config;

import com.school.project.schooldbproject.catalogue.repository.CatalogueMemoryRepository;
import com.school.project.schooldbproject.catalogue.repository.CatalogueRepository;
import com.school.project.schooldbproject.user.repository.UserJpaRepository;
import com.school.project.schooldbproject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class DatabaseConfig {

    private final EntityManager em;

    @Autowired
    public DatabaseConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public CatalogueRepository catalogueRepository() {
        return new CatalogueMemoryRepository();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserJpaRepository(em);
//        return new UserMemoryRepositoryImpl();
    }
}
