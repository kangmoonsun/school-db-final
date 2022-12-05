package com.school.project.schooldbproject.branch.entity;

import com.school.project.schooldbproject.order.entity.Payment;
import com.school.project.schooldbproject.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branches")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Inventory> inventories;

    @OneToMany
    private List<Payment> payments;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @OneToOne(optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User owner;
}
