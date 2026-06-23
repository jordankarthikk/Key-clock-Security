package com.Keyclock.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping("/info")
    public String userInfo(@RequestHeader(value = "Authorization",
            required = false)  String auth) {

        return "USER-SERVICE"+ auth;
    }
}
