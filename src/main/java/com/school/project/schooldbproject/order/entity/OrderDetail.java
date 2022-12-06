package com.school.project.schooldbproject.order.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.project.schooldbproject.branch.entity.Inventory;
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
    @Column(name = "order_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    private Long totalPrice;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalogue_id")
    private Catalogue catalogue;

    public static OrderDetail createOrderItem(Inventory stock, Long quantity) {
        Catalogue catalogue = stock.getCatalogue();
        Long totalPrice = catalogue.getPrice() * quantity;

        OrderDetail orderItem = OrderDetail.builder()
                .catalogue(catalogue)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();

        stock.removeStock(quantity);
        return orderItem;
    }


//    public OrderDetail createOrderItem(Catalogue catalogue) {
//        Long totalPrice = getTotalPrice(catalogue, quantity);

//        return OrderDetail.builder()
//                .catalogue(catalogue)
//                .quantity(quantity)
//                .totalPrice(totalPrice)
//                .build();
//    }
}
