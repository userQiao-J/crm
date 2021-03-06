package com.userqiao.crm.controller;

import com.userqiao.crm.model.Menu;
import com.userqiao.crm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author userqiao
 * @Title: SystemConfigController
 * @Package com.userqiao.crm.controller
 * @Description: 系统配置Controller
 * @date 2020/6/718:41
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;
    @GetMapping("/getMenu")
    public List<Menu> getMenusByUserId(){
        return menuService.getMenusByUserId();
    }
}
