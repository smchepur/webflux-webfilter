package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomRequestWebFilter implements WebFilter{
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if(exchange.getRequest().getQueryParams().containsKey("user")){
            log.info("From Filter 1: Inside the queryParam check");
            exchange.getResponse().getHeaders().add("customHeader", "securitycloud");
        }
        for(int i=0; i< 2; i++) {
            log.info("Printing i for 2 times");
        }
        log.info("From Filter 1");
        return chain.filter(exchange);
    }
}
