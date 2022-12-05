package com.school.project.schooldbproject.branch.entity;

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
    @Column(name = "branchId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Inventory> inventories;

    @OneToOne
    @JoinColumn(name = "userId")
    private User owner;
}
