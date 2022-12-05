package com.school.project.schooldbproject.branch.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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
