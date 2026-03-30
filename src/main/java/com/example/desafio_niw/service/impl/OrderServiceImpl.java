package com.example.desafio_niw.service.impl;

import com.example.desafio_niw.data.Order;
import com.example.desafio_niw.data.OrderItem;
import com.example.desafio_niw.data.enums.OrderStatus;
import com.example.desafio_niw.data.repository.OrderRepository;
import com.example.desafio_niw.model.OrderDTO;
import com.example.desafio_niw.model.OrderItemDTO;
import com.example.desafio_niw.model.mapper.EntityMapper;
import com.example.desafio_niw.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final EntityMapper entityMapper;

    @Override
    public BigDecimal calculateTotal(OrderDTO order) {

        BigDecimal total = BigDecimal.ZERO;

        if (order == null || order.getItems() == null) {
            return BigDecimal.ZERO;
        }

        for (OrderItemDTO item : order.getItems()) {
            BigDecimal subtotal = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            total = total.add(subtotal);
        }
        return total;
    }

    @Override
    public BigDecimal calculateTotalOrder(Long id) {

        Order order = orderRepository.findAll().stream()
                .filter(o -> o.getId() != null && o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found with0 id: " + id));

        return this.calculateTotal(entityMapper.entityToOrderDTO(order));
    }
    @Override
    public Map<OrderStatus, List<OrderDTO>> groupByStatus(List<OrderDTO> orders) {
        if (orders == null) {
            return Map.of();
        }
        return orders.stream()
                .collect(Collectors.groupingBy(OrderDTO::getStatus));
    }

    @Override
    public Optional<OrderDTO> findMostExpensives(List<OrderDTO> orders) {
        if (orders == null) {
            return Optional.empty();
        }
        return orders.stream()
                .max(Comparator.comparing(this::calculateTotal));
    }

    public OrderDTO create(OrderDTO orderDTO) {
        Order order = entityMapper.OrderDTOtoEntity(orderDTO);
        return entityMapper.entityToOrderDTO(orderRepository.save(order));
    }

    public List<OrderDTO> findByCustomerId(Long customerId) {
        if (customerId == null) {
            return List.of();
        }
        return entityMapper.entityToOrderDTOList(orderRepository.findByCustomerId(customerId));
    }

    @Override
    public List<OrderDTO> findAll() {
        return entityMapper.entityToOrderDTOList(orderRepository.findAll());
    }
}
