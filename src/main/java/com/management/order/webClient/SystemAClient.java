package com.management.order.webClient;

import org.springframework.stereotype.Component;
import com.management.order.dto.Order;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Component
public class SystemAClient {

    private final WebClient webClient;

    public SystemAClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://sistema-a.com/api").build();
    }

    public List<Order> fetchOrders() {
        return webClient.get()
                .uri("/orders")
                .retrieve()
                .bodyToFlux(Order.class)
                .collectList()
                .block();
    }
}
