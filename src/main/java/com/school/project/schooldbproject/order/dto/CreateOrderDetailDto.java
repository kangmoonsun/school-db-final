package com.school.project.schooldbproject.order.dto;

import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import com.school.project.schooldbproject.order.entity.OrderDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderDetailDto {
    private Long catalogueId;
    private Long quantity;

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
