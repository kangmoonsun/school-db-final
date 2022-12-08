package com.school.project.schooldbproject.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CreatePaymentDto {
    private Long branchId;
    private List<CreateOrderDetailDto> orderDetails;
}
