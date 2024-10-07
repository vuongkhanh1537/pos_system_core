package com.longhuei.pos_system_core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] SWAGGER_WHITELIST = {
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**",
        "swagger-ui/index.html/**",
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/docs.html"
    };

    private final String[] PUBLIC_ENDPOINTS = {"/api/v1/auth/login", "/api/v1/auth/logout", "/api/v1/product/create"};

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.addAllowedOrigin("*");
        config.setExposedHeaders(Collections.singletonList("Authorization,Link,X-Total-Count"));
        config.setAllowCredentials(false);
        if (config.getAllowedOrigins() != null && !config.getAllowedOrigins().isEmpty()) {
            source.registerCorsConfiguration("/api/v1/**", config);
            source.registerCorsConfiguration("/v2/api-docs", config);
        }
        return new CorsFilter(source);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);

//        http.authorizeHttpRequests(req ->
//            req
//            .requestMatchers(HttpMethod.POST, PUBLIC_ENDPOINTS).permitAll()
//            .requestMatchers(SWAGGER_WHITELIST).permitAll()
//            .anyRequest().authenticated()
//        );

         http.authorizeHttpRequests(req ->
             req
             .requestMatchers(HttpMethod.POST, PUBLIC_ENDPOINTS).permitAll()
             .requestMatchers(SWAGGER_WHITELIST).permitAll()
             .anyRequest().permitAll()
         );

        return http.build();
    }
}
