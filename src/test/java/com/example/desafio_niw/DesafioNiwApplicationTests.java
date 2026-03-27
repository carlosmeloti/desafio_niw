package com.example.desafio_niw;

import com.example.desafio_niw.data.Customer;
import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.OrderItem;
import com.example.desafio_niw.data.enums.OrderStatus;
import com.example.desafio_niw.data.repository.OrderRepository;
import com.example.desafio_niw.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DesafioNiwApplicationTests {

    @Mock
    private OrderRepository orderRepository;

    private OrderServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new OrderServiceImpl(orderRepository);
    }

    @Test
    void calculateTotal_emptyList_returnsZero() {
        Order order = new Order();
        order.setItems(List.of());

        BigDecimal total = service.calculateTotal(order);

        assertEquals(BigDecimal.ZERO, total);
    }

    @Test
    void calculateTotal_singleItem_returnsCorrectValue() {
        OrderItem item = new OrderItem();
        item.setPrice(new BigDecimal("10.00"));
        item.setQuantity(2L);

        Order order = new Order();
        order.setItems(List.of(item));

        BigDecimal total = service.calculateTotal(order);

        assertEquals(new BigDecimal("20.00"), total);
    }

    @Test
    void calculateTotal_multipleItems_returnsSumOfAll() {
        OrderItem item1 = new OrderItem();
        item1.setPrice(new BigDecimal("5.00"));
        item1.setQuantity(3L);

        OrderItem item2 = new OrderItem();
        item2.setPrice(new BigDecimal("7.50"));
        item2.setQuantity(2L);

        Order order = new Order();
        order.setItems(List.of(item1, item2));

        BigDecimal total = service.calculateTotal(order);

        assertEquals(new BigDecimal("30.00"), total);
    }

    @Test
    void getOrdersByCustomers_filtersCorrectly() {
        Customer c1 = new Customer();
        c1.setId(1L);

        Customer c2 = new Customer();
        c2.setId(2L);

        Order o1 = new Order();
        o1.setId(1L);
        o1.setCustomer(c1);
        o1.setStatus(OrderStatus.PENDING);
        o1.setItems(List.of());

        Order o2 = new Order();
        o2.setId(2L);
        o2.setCustomer(c2);
        o2.setStatus(OrderStatus.SHIPPED);
        o2.setItems(List.of());

        Order o3 = new Order();
        o3.setId(3L);
        o3.setCustomer(c1);
        o3.setStatus(OrderStatus.PENDING);
        o3.setItems(List.of());

        List<Order> orders = List.of(o1, o2, o3);

        List<Order> filtered = service.getOrdersByCustomers(orders, "1");

        assertEquals(2, filtered.size());
    }


}
