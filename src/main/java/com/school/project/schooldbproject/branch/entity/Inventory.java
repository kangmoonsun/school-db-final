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
    @Column(name = "inventoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    private Date createdAt;

    @Column(name = "catalogueId")
    private Long catalogueId;

    @ManyToOne
    @JoinColumn(name = "catalogueId")
    private Catalogue catalogue;


    @Column(name = "bracnhId")
    private Long branchId;

    @ManyToOne
    private Branch branch;

}
