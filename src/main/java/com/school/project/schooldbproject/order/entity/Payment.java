package com.school.project.schooldbproject.order.entity;

import com.school.project.schooldbproject.branch.entity.Branch;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totalPrice;

    private Date createdAt;

    @Column(name = "branchId", nullable = false)
    private Long branchId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "branchId", referencedColumnName = "id", insertable = false, updatable = false)
    private Branch branch;

    @OneToMany
    private List<OrderDetail> orderDetails;

}
