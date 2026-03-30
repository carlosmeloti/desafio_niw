package com.example.desafio_niw;

import com.example.desafio_niw.data.Customer;
import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.OrderItem;
import com.example.desafio_niw.data.enums.OrderStatus;
import com.example.desafio_niw.data.repository.OrderRepository;
import com.example.desafio_niw.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class OrderServiceFullTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderServiceImpl service;

//    @Test
//    void fullServiceDemo() {
//        service = new OrderServiceImpl(orderRepository);
//
//        Customer c1 = new Customer();
//        c1.setId(1L);
//
//        Customer c2 = new Customer();
//        c2.setId(2L);
//
//        OrderItem item1 = new OrderItem();
//        item1.setProductId("P1");
//        item1.setPrice(new BigDecimal("10.00"));
//        item1.setQuantity(2L);
//
//        OrderItem item2 = new OrderItem();
//        item2.setProductId("P2");
//        item2.setPrice(new BigDecimal("5.00"));
//        item2.setQuantity(3L);
//
//        OrderItem item3 = new OrderItem();
//        item3.setProductId("P3");
//        item3.setPrice(new BigDecimal("20.00"));
//        item3.setQuantity(1L);
//
//        Order o1 = new Order();
//        o1.setId(1L);
//        o1.setCustomer(c1);
//        o1.setStatus(OrderStatus.PENDING);
//        o1.setItems(List.of(item1, item2));
//
//        Order o2 = new Order();
//        o2.setId(2L);
//        o2.setCustomer(c2);
//        o2.setStatus(OrderStatus.SHIPPED);
//        o2.setItems(List.of(item3));
//
//        Order o3 = new Order();
//        o3.setId(3L);
//        o3.setCustomer(c1);
//        o3.setStatus(OrderStatus.PENDING);
//        o3.setItems(List.of(item2));
//
//        List<Order> orders = List.of(o1, o2, o3);
//
//        System.out.println("=== TOTALS ===");
//        orders.forEach(order ->
//                System.out.println("Order " + order.getId() + " total = " + service.calculateTotal(order))
//        );
//
//        System.out.println("\n=== ORDERS BY CUSTOMER 1 ===");
//        List<Order> byCustomer = service.getOrdersByCustomers(orders, "1");
//        byCustomer.forEach(o -> System.out.println("Order " + o.getId()));
//
//        System.out.println("\n=== GROUP BY STATUS ===");
//        Map<OrderStatus, List<Order>> grouped = service.groupByStatus(orders);
//        grouped.forEach((status, list) -> {
//            System.out.println(status + ":");
//            list.forEach(o -> System.out.println("  Order " + o.getId()));
//        });
//
//        System.out.println("\n=== MOST EXPENSIVE ORDER ===");
//        service.findMostExpensives(orders)
//                .ifPresent(o -> System.out.println("Most expensive is Order " + o.getId()));
//    }
}