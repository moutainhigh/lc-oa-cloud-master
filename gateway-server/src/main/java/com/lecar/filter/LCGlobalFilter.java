package com.lecar.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class LCGlobalFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("--------------------【global filter】----------begin--------------->");
        Mono<Void> mono= chain.filter(exchange);
        log.info("<--------------------【global filter】----------end---------------");
        return  mono;
    }

    @Override
    public int getOrder() {
        return -1;
    }
}