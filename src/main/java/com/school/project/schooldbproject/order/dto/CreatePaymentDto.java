package com.school.project.schooldbproject.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreatePaymentDto {
    private Long branchId;
    private List<CreateOrderDetailDto> orderDetails;

//    private List<OrderDetail> getOrderDetailEntities() {
//        return orderDetails
//                .stream()
//                .map(item -> item.toEntity())
//                .collect(Collectors.toList());
//    }
//
//    public Payment toEntity() {
//        List<OrderDetail> orderDetailEntities = getOrderDetailEntities();
//
//        Payment.builder()
//                .orderDetails(orderDetailEntities)
//                .totalPrice(1)
//                .build();
//    }
}
