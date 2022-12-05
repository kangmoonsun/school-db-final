package com.school.project.schooldbproject.order.entity;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    private Long totalPrice;

    @Column(name = "paymentId", nullable = false)
    private Long paymentId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paymentId", referencedColumnName = "id", insertable = false, updatable = false)
    private Payment payment;

    @Column(name = "catalogueId", nullable = false)
    private Long catalogueId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "catalogueId", referencedColumnName = "id", insertable = false, updatable = false)
    private Catalogue catalogue;
}
