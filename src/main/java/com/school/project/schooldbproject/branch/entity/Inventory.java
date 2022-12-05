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

    @ManyToOne
    private Catalogue catalogue;

    @ManyToOne
    private Branch branch;

}
