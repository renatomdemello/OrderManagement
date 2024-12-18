package com.management.order.service;

import com.management.order.dto.Order;
import com.management.order.dto.Product;
import com.management.order.repository.OrderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testProcessOrder() {
        // Arrange
        Order orderDto = new Order();
        orderDto.setExternalId("EXTERNAL_456");
        orderDto.setProducts(Arrays.asList(
                new Product(),
                new Product()
        ));

        Order processedOrder = orderService.processOrder(orderDto);

        assertNotNull(processedOrder);
        assertEquals("PROCESSED", processedOrder.getStatus());
        assertEquals(150.0, processedOrder.getTotalValue(), 0.01);
    }
}
