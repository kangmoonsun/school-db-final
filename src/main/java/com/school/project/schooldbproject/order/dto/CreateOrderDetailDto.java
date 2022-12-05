package com.school.project.schooldbproject.order.dto;

import com.school.project.schooldbproject.order.entity.OrderDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderDetailDto {
    private Long catalogueId;
    private Long quantity;

    public OrderDetail toEntity() {
        return OrderDetail.builder()
//                .paymentId()
                .catalogueId(catalogueId)
                .quantity(quantity)
                .build();
    }
}
