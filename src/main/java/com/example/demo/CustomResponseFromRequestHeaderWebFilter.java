package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@Slf4j
public class CustomResponseFromRequestHeaderWebFilter implements WebFilter{
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if(exchange.getResponse().getHeaders().containsKey("customHeader")){
            exchange.getResponse().getHeaders().add("customToken", UUID.randomUUID().toString());
        }
        log.info("From Filter 2");
        return chain.filter(exchange);
    }
}
