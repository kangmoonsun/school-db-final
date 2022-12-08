package com.school.project.schooldbproject.order.dto;

import com.school.project.schooldbproject.branch.dto.BranchDto;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import com.school.project.schooldbproject.order.entity.OrderDetail;
import com.school.project.schooldbproject.order.entity.Payment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PaymentDto {

    @Getter
    @NoArgsConstructor
    public static class Response {
        private Long id;

        private Long totalPrice;

        private Date createdAt;

        private BranchDto.Response branch;

        private List<OrderDetailDto> orderDetailDtos = new ArrayList<>();

        public Response(Payment entity) {
            this.id = entity.getId();
            this.totalPrice = entity.getTotalPrice();
            this.createdAt = entity.getCreatedAt();
            this.branch = new BranchDto.Response(entity.getBranch());
            this.orderDetailDtos = entity.getOrderDetails()
                    .stream()
                    .map(OrderDetailDto::new)
                    .collect(Collectors.toList());
        }
    }

    @Getter
    public static class OrderDetailDto {
        private Long id;

        private Long quantity;

        private Long totalPrice;

        private Catalogue catalogue;

        public OrderDetailDto(OrderDetail entity) {
            this.id = entity.getId();
            this.quantity = entity.getQuantity();
            this.totalPrice = entity.getTotalPrice();
            this.catalogue = entity.getCatalogue();
        }
    }


}
