package com.Keyclock.order_service.controller;




import com.Keyclock.order_service.feign.ProductFeign;
import com.Keyclock.order_service.feign.UserFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final UserFeign userFeign;
    private final ProductFeign productFeign;

    public OrderController(UserFeign userFeign, ProductFeign productFeign) {
        this.userFeign = userFeign;
        this.productFeign = productFeign;
    }

    @GetMapping
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
}
