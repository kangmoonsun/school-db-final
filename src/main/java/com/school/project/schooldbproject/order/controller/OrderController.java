package com.school.project.schooldbproject.order.controller;

import com.school.project.schooldbproject.order.dto.CreateOrderDetailDto;
import com.school.project.schooldbproject.order.dto.CreatePaymentDto;
import com.school.project.schooldbproject.order.entity.OrderDetail;
import com.school.project.schooldbproject.order.entity.Payment;
import com.school.project.schooldbproject.order.service.OrderDetailService;
import com.school.project.schooldbproject.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final PaymentService paymentService;
    private final OrderDetailService orderDetailService;


    @Autowired
    public OrderController(PaymentService paymentService, OrderDetailService orderDetailService) {
        this.paymentService = paymentService;
        this.orderDetailService = orderDetailService;
    }


    @PostMapping("payment")
    @ResponseBody
    public Payment createPayment(@RequestBody CreatePaymentDto createPaymentDto) {
        return this.paymentService.createPayment(createPaymentDto);
    }


    @PostMapping("order-detail")
    @ResponseBody
    public OrderDetail createOrderDetailDto(@RequestBody CreateOrderDetailDto createOrderDetailDto) {
        return this.orderDetailService.createOrderDetail(createOrderDetailDto);
    }

}
