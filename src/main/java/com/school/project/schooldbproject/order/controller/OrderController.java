package com.school.project.schooldbproject.order.controller;

import com.school.project.schooldbproject.order.dto.CreatePaymentDto;
import com.school.project.schooldbproject.order.dto.PaymentDto;
import com.school.project.schooldbproject.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    private final PaymentService paymentService;

    @Autowired
    public OrderController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("payment")
    @ResponseBody
    public PaymentDto.Response createPayment(@Valid @RequestBody CreatePaymentDto createPaymentDto) {
        return this.paymentService.createPayment(createPaymentDto);
    }

    @GetMapping("branch/{id}/payments")
    @ResponseBody
    public List<PaymentDto.Response> findPaymentsByBranchId(@PathVariable(name = "id") String branchId) {
        return this.paymentService.findPaymentsByBranchId(Long.valueOf(branchId));
    }
}

