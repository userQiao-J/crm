package com.userqiao.crm.controller.system.basic;

import cn.hutool.core.util.ObjectUtil;
import com.userqiao.crm.aop.OperLog;
import com.userqiao.crm.controller.BaseController;
import com.userqiao.crm.model.Menu;
import com.userqiao.crm.model.RespBean;
import com.userqiao.crm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author userqiao
 * @Title: MenuController
 * @Package com.userqiao.crm.controller.basic
 * @Description: 菜单控制器
 * @date 2020/7/5 14:44
 */
@RestController
@RequestMapping("/system/basic/menu")
public class MenuController extends BaseController {
    @Autowired
    MenuService menuService;

    /**
     * 根据菜单ID查看详情
     *
     * @param mid
     * @return
     */
    @GetMapping("/{mid}")
    @OperLog(operModul = "基础信息设置-菜单管理", operType = LOGCONST_GET, operDesc = "根据菜单ID查看详情")
    public RespBean getMenuById(@PathVariable("mid") Integer mid) {
        Menu menu = menuService.getMenuById(mid);
        if (ObjectUtil.isNotEmpty(menu)) {
            return RespBean.ok("查询成功", menu);
        }
        return RespBean.error("查询失败");
    }

    @PostMapping("/")
    @OperLog(operModul = "基础信息设置-菜单管理")
    public RespBean addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }
}
