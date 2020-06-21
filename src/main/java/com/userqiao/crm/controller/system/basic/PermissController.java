package com.userqiao.crm.controller.system.basic;

import com.userqiao.crm.model.Menu;
import com.userqiao.crm.model.RespBean;
import com.userqiao.crm.model.Role;
import com.userqiao.crm.service.MenuService;
import com.userqiao.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author userqiao
 * @Title: PermissController
 * @Package com.userqiao.crm.controller.system.basic
 * @Description: 权限组控制器
 * @date 2020/6/21 14:33
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @GetMapping("/getAllRoles")
    public RespBean getAllRoles(){
        List<Role> role = roleService.getAllRole();
        return RespBean.ok("查询成功",role);
    }

    @GetMapping("/menus")
    public RespBean getAllMenus(){
        List<Menu> allMenus = menuService.getAllMenus();
        return RespBean.ok("查询成功",allMenus);
    }
}
