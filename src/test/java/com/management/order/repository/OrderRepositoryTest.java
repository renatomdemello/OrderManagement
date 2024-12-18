package com.management.order.repository;

import com.management.order.dto.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSaveOrder() {
        // Arrange
        Order order = new Order();
        order.setExternalId("EXTERNAL_123");
        order.setTotalValue(150.0);
        order.setStatus("PROCESSED");

        // Act
        Order savedOrder = orderRepository.save(order);

        // Assert
        assertNotNull(savedOrder.getId());
        assertEquals("EXTERNAL_123", savedOrder.getExternalId());
    }
}
