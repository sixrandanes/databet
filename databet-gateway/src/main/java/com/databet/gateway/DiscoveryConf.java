package com.databet.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class DiscoveryConf {
/*
    @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteLocator(DiscoveryClient discoveryClient) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
    }*/
/*
    @Bean
    public RouteLocator customRouteLocator(
   return Routes.locator()
        .route("admin")
        .predicate(path("/football-data/**"))
            .uri("lb://databet-ref")
        .build();
        */

  /*  @Bean
    public DiscoveryClientRouteDefinitionLocator clientRouteDefinitionLocator(DiscoveryClient discoveryClient) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, null);
    }*/
/*
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(
                        r -> r.path("/football-data/**")
                                .uri("lb://databet-ref")
                )
                .build();
    }*/
}
