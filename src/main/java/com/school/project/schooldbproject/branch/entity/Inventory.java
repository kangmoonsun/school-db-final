package com.school.project.schooldbproject.branch.entity;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;
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

    private Long quantity;

    private Date createdAt;

    @Column(name = "branchId", nullable = false)
    private Long branchId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "branchId", referencedColumnName = "id", insertable = false, updatable = false)
    private Branch branch;

    @Column(name = "catalogueId", nullable = false)
    private Long catalogueId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "catalogueId", referencedColumnName = "id", insertable = false, updatable = false)
    private Catalogue catalogue;


}
