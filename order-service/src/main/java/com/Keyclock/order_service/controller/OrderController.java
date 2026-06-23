package com.Keyclock.order_service.controller;




import com.Keyclock.order_service.feign.ProductFeign;
import com.Keyclock.order_service.feign.UserFeign;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final UserFeign userFeign;
    private final ProductFeign productFeign;

    public OrderController(UserFeign userFeign, ProductFeign productFeign) {
        this.userFeign = userFeign;
        this.productFeign = productFeign;
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public String getOrders() {
        String user =
                userFeign.userInfo();

        String product =
                productFeign.productInfo();

        return "ORDER -> "
                + user
                + " -> "
                + product;
    }
    @GetMapping("/authorities")
    public List<String> authorities(Authentication authentication) {

        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }
}
