package com.Keyclock.order_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("USER-SERVICE")
public interface UserFeign {

    @GetMapping("/users/info")
    String userInfo();
}
