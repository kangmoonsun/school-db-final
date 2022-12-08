package com.school.project.schooldbproject.util;

import com.school.project.schooldbproject.branch.dto.BranchDto;
import com.school.project.schooldbproject.branch.dto.CreateInventoryDto;
import com.school.project.schooldbproject.branch.service.InventoryService;
import com.school.project.schooldbproject.catalogue.dto.CatalogueDto;
import com.school.project.schooldbproject.catalogue.service.CatalogueService;
import com.school.project.schooldbproject.order.dto.CreateOrderDetailDto;
import com.school.project.schooldbproject.order.dto.CreatePaymentDto;
import com.school.project.schooldbproject.order.dto.PaymentDto;
import com.school.project.schooldbproject.order.service.PaymentService;
import com.school.project.schooldbproject.user.dto.CreateUserDto;
import com.school.project.schooldbproject.user.dto.UserDto;
import com.school.project.schooldbproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoService {
    private final UserService userService;
    private final CatalogueService catalogueService;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    @Autowired
    public DemoService(UserService userService, CatalogueService catalogueService, InventoryService inventoryService, PaymentService paymentService) {
        this.userService = userService;
        this.catalogueService = catalogueService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    @Transactional
    public void createMockData() {
        List<UserDto.Response> users = createMockUsers();
        List<CatalogueDto.Response> catalogues = createMockCatalogues();
        createMockStocks(users, catalogues);
        List<PaymentDto.Response> payments = createMockPayments(users, catalogues);
    }

    private List<PaymentDto.Response> createMockPayments(List<UserDto.Response> users, List<CatalogueDto.Response> catalogues) {
        return users.stream()
                .map(user -> {
                    List<CreateOrderDetailDto> orderDetails = catalogues
                            .stream()
                            .map(catalogue -> new CreateOrderDetailDto(catalogue.getId(), 5L))
                            .collect(Collectors.toList());

                    CreatePaymentDto createPaymentDto = new CreatePaymentDto(user.getBranch().getId(), orderDetails);
                    return paymentService.createPayment(createPaymentDto);

                })
                .collect(Collectors.toList());
    }

    private void createMockStocks(List<UserDto.Response> users, List<CatalogueDto.Response> catalogues) {
        users.forEach(user -> {
            BranchDto.Response branch = user.getBranch();

            catalogues.forEach(catalogue -> {
                CreateInventoryDto addStockDto = CreateInventoryDto.builder()
                        .catalogueId(catalogue.getId())
                        .branchId(branch.getId())
                        .quantity(20L)
                        .build();

                inventoryService.addStock(addStockDto);
            });
        });
    }

    private List<CatalogueDto.Response> createMockCatalogues() {
        List<CatalogueDto.Response> catalogues = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            CatalogueDto.CreateDto catalogueDto = CatalogueDto.CreateDto.builder()
                    .name("빵" + i)
                    .price(i * 1000L)
                    .build();

            CatalogueDto.Response catalogue = catalogueService.createCatalogue(catalogueDto);
            catalogues.add(catalogue);
        }

        return catalogues;
    }

    private List<UserDto.Response> createMockUsers() {
        CreateUserDto createUserDto1 = CreateUserDto.builder()
                .name("지성현")
                .email("jee@google.com")
                .password("123456")
                .role("OWNER")
                .branchName("파리바게트-강남대점")
                .build();
        UserDto.Response user1 = userService.createUser(createUserDto1);

        CreateUserDto createUserDto2 = CreateUserDto.builder()
                .name("지2성")
                .email("j2222@google.com")
                .password("123456")
                .role("OWNER")
                .branchName("파리바게트-양재점")
                .build();
        UserDto.Response user2 = userService.createUser(createUserDto2);

        List<UserDto.Response> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        return users;
    }

}
