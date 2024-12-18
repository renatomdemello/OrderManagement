package com.management.order.service;

import com.management.order.dto.Order;
import com.management.order.dto.Product;

import com.management.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order processOrder(Order orderDto) {
        // Evitar duplicação
        if (orderRepository.findByExternalId(orderDto.getExternalId()).isPresent()) {
            throw new IllegalArgumentException("Pedido já processado.");
        }

        // Calcular total
        Double totalValue = orderDto.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        // Salvar pedido
        Order order = new Order();
        order.setExternalId(orderDto.getExternalId());
        order.setTotalValue(totalValue);
        order.setStatus("PROCESSED");
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }
}
