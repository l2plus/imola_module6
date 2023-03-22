package com.epam.sarai.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder, @Value("${first.service.id}") String firstServiceId,
                                      @Value("${first.service.uri}") String firstServiceUri,
                                      @Value("${first.service.predicates}") String firstServicePredicate,
                                      @Value("${second.service.id}") String secondServiceId,
                                      @Value("${second.service.uri}") String secondServiceUri,
                                      @Value("${second.service.predicates}") String secondServicePredicate,
                                      @Value("${employee.info.service.id}") String employeeInfoServiceId,
                                      @Value("${employee.info.service.uri}") String employeeInfoServiceUri,
                                      @Value("${employee.info.service.predicates}") String employeeInfoServicePredicate
    ) {
        return builder.routes()
                .route(p -> p
                        .path(firstServicePredicate)
                        .uri(firstServiceUri)
                        .id(firstServiceId))
                .route(p -> p
                        .path(secondServicePredicate)
                        .uri(secondServiceUri)
                        .id(secondServiceId))
                .route(p -> p
                        .path(employeeInfoServicePredicate)
                        .uri(employeeInfoServiceUri)
                        .id(employeeInfoServiceId))
                .build();
    }
}