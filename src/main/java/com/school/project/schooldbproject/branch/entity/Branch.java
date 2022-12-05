package com.school.project.schooldbproject.branch.entity;

import lombok.*;

import javax.persistence.*;

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

    /**
     * Inventory one to many
     * */
}
