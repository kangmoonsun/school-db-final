package com.school.project.schooldbproject.branch.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * FK
     * Catalogue Many to one
     */
    private Long catalogueId;

    /**
     * FK
     * Branch Many to one
     */
    private Long branchId;

    private Long quantity;

    private Date createdAt;
}
