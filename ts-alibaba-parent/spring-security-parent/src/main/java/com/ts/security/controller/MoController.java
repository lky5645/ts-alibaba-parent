package com.ts.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MoController
 * @Description TODO
 * @Author 86175
 * @Date 2020/5/7 8:55
 * @Params TODO
 */
@RestController
public class MoController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
