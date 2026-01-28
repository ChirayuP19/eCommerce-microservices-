package com.ecommerce.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("product-service",
                        x->x.path("/api/v1/products/**")
                                .uri("http://localhost:8081"))
                .route("user-service",x->x.path("/api/v1/users/**")
                                .uri("http://localhost:8082"))
                .route("order-services",a->a.path("/api/v1/orders/**")
                                .uri("http://localhost:8083"))
                .route("order-services",a->a.path("/api/v1/cart/**")
                        .uri("http://localhost:8083"))
                .route("eureka-server",a->a.path("/eureka/main")
                        .filters(f->f.rewritePath("/eureka/main","/"))
                        .uri("http://localhost:8761"))
                .route("eureka-server-static",a->a.path("/eureka/**")
                        .uri("http://localhost:8761"))
                .build();

    }
}
