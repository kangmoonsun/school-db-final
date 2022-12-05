package com.school.project.schooldbproject.catalogue.entity;

import com.school.project.schooldbproject.branch.entity.Inventory;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "catalogues")
public class Catalogue {
    @Id
    @Column(name = "catalogueId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    @OneToMany
    private List<Inventory> inventories;

}
