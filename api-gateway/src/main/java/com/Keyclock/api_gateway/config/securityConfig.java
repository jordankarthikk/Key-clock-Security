package com.Keyclock.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteLocator;


@Configuration
public class securityConfig {

    @Bean
    public SecurityWebFilterChain security(ServerHttpSecurity http) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(ex -> ex
                        .pathMatchers("/public/**").permitAll()
                        .anyExchange().authenticated()
                )
//                .oauth2Login(oauth -> {})
                .oauth2ResourceServer(oauth -> oauth.jwt(jwt->{}))
                .build();
    }

    @Bean
    CommandLineRunner routes(RouteLocator routeLocator) {
        return args -> {
            routeLocator.getRoutes()
                    .subscribe(route ->
                            System.out.println("ROUTE FOUND => " + route.getId()));
        };
}
}