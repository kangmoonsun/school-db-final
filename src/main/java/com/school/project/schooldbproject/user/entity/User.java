package com.school.project.schooldbproject.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.project.schooldbproject.branch.entity.Branch;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String role;

    @JsonManagedReference
    @OneToOne(mappedBy = "owner")
    private Branch branch;
}
