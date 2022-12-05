package com.school.project.schooldbproject.order.service;

import com.school.project.schooldbproject.order.dto.CreateOrderDetailDto;
import com.school.project.schooldbproject.order.dto.CreatePaymentDto;
import com.school.project.schooldbproject.order.entity.Payment;
import com.school.project.schooldbproject.order.repository.OrderDetailRepository;
import com.school.project.schooldbproject.order.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderDetailRepository orderDetailRepository) {
        this.paymentRepository = paymentRepository;
        this.orderDetailRepository = orderDetailRepository;
    }


    @Override
    public Payment createPayment(CreatePaymentDto createPaymentDto) {
        List<CreateOrderDetailDto> orderDetails = createPaymentDto.getOrderDetails();

        return null;
    }
}
