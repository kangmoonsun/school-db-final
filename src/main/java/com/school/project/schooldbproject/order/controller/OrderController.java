package com.school.project.schooldbproject.order.controller;

import com.school.project.schooldbproject.order.dto.CreatePaymentDto;
import com.school.project.schooldbproject.order.entity.Payment;
import com.school.project.schooldbproject.order.service.OrderDetailService;
import com.school.project.schooldbproject.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    private final PaymentService paymentService;


    @Autowired
    public OrderController(PaymentService paymentService, OrderDetailService orderDetailService) {
        this.paymentService = paymentService;
    }

    @PostMapping("payment")
    @ResponseBody
    public Payment createPayment(@Valid @RequestBody CreatePaymentDto createPaymentDto) {
        return this.paymentService.createPayment(createPaymentDto);
    }

    @GetMapping("branch/{id}/payments")
    @ResponseBody
    public List<Payment> findPaymentsByBranchId(@PathVariable(name = "id") String branchId) {
        return this.paymentService.findPaymentsByBranchId(Long.valueOf(branchId));
    }
}
