package com.userqiao.crm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author userqiao
 * @Title: RespBean
 * @Package com.userqiao.crm.controller
 * @Description: Hello接口
 * @date 2020/6/6 9:12
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
