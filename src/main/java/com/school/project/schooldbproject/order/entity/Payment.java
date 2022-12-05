package com.school.project.schooldbproject.order.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totalPrice;

    private Date createdAt;

    /**
     * FK Branch Many to one
     * */
}
