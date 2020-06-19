package com.userqiao.crm.controller;

import com.userqiao.crm.model.RespBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author userqiao
 * @Title: LoginController
 * @Package com.userqiao.crm
 * @Description: LoginController
 * @date 2020/6/610:45
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录");
    }
}
