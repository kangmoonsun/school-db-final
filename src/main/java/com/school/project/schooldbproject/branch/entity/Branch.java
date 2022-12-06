package com.school.project.schooldbproject.branch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.project.schooldbproject.order.entity.Payment;
import com.school.project.schooldbproject.user.entity.User;
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
@Table(name = "branches")
public class Branch {
    @Id
    @Column(name = "branch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private List<Inventory> inventories = new ArrayList<Inventory>();

    @JsonManagedReference
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private List<Payment> payments = new ArrayList<Payment>();

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;


    public void setOwner(User owner) {
        this.owner = owner;
        owner.setBranch(this);
    }
}
