package com.school.project.schooldbproject.order.service;

import com.school.project.schooldbproject.order.dto.CreateOrderDetailDto;
import com.school.project.schooldbproject.order.entity.OrderDetail;

public interface OrderDetailService {
    OrderDetail createOrderDetail(CreateOrderDetailDto createOrderDetailDto);
}
