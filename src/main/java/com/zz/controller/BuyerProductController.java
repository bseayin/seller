package com.zz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerProductController {
    @RequestMapping("tt")
    public String init(){
        return "hello";
    }
}
