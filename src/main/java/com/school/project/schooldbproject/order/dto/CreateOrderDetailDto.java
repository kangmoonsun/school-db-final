package com.school.project.schooldbproject.order.dto;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import com.school.project.schooldbproject.order.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderDetailDto {
    private Long catalogueId;
    private Long quantity;


    public OrderDetail createOrderItem(Catalogue catalogue) {
        Long totalPrice = getTotalPrice(catalogue, quantity);

        return OrderDetail.builder()
                .catalogue(catalogue)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();
    }

    private Long getTotalPrice(Catalogue catalogue, Long quantity) {
        return catalogue.getPrice() * quantity;
    }


    public OrderDetail toEntity() {
        Catalogue catalogue = new Catalogue();
        catalogue.setId(catalogueId);

        return OrderDetail.builder()
                .catalogue(catalogue)
//                .paymentId()
                .quantity(quantity)
                .build();
    }
}
