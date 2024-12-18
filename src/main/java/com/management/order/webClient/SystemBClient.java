package com.management.order.webClient;

import com.management.order.dto.Order;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SystemBClient {

    private final WebClient webClient;

    public SystemBClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://sistema-b.com/api").build();
    }

    public void sendOrder(Order orderDto) {
        webClient.post()
                .uri("/calculated-orders")
                .bodyValue(orderDto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
