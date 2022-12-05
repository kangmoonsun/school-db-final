package com.school.project.schooldbproject.catalogue.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.project.schooldbproject.branch.entity.Inventory;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
    @Column(name = "catalogue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY)
    private List<Inventory> inventories = new ArrayList<Inventory>();
}
