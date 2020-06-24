package com.userqiao.crm.controller.system.basic;

import com.userqiao.crm.aop.OperLog;
import com.userqiao.crm.controller.BaseController;
import com.userqiao.crm.model.Menu;
import com.userqiao.crm.model.RespBean;
import com.userqiao.crm.model.Role;
import com.userqiao.crm.service.MenuService;
import com.userqiao.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class PermissController extends BaseController {

    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @GetMapping("/getAllRoles")
    @OperLog(operModul = "基础配置-权限组",operType = LOGCONST_GET,operDesc = "查询出所有的角色")
    public RespBean getAllRoles(){
        List<Role> role = roleService.getAllRole();
        return RespBean.ok("查询成功",role);
    }

    @GetMapping("/menus")
    @OperLog(operModul = "基础配置-菜单列表",operType = LOGCONST_GET,operDesc = "查询出菜单列表")
    public RespBean getAllMenus(){
        List<Menu> allMenus = menuService.getAllMenus();
        return RespBean.ok("查询成功",allMenus);
    }

    @DeleteMapping("/deleteRole/{roleId}")
    @OperLog(operModul = "基础配置-权限组",operType = LOGCONST_DELETE,operDesc = "删除角色")
    public RespBean deleteRoleById(@PathVariable("roleId") String roleId){
        return roleService.deleteRole(roleId);
    }
}
