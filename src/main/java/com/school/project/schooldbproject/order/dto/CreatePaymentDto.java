package com.school.project.schooldbproject.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreatePaymentDto {
    private Long branchId;
    private List<CreateOrderDetailDto> orderDetails;


//
//    public Payment toEntity() {
//
//        Payment.builder()
//                .totalPrice(1)
//                .build();
//    }
}
