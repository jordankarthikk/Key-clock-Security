package com.Keyclock.order_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


    @FeignClient("PRODUCT-SERVICE")
    public interface ProductFeign {

        @GetMapping("/products/info")
        String productInfo();
    }

