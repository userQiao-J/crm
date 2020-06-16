package com.userqiao.crm.service;

import com.userqiao.crm.model.Menu;

import java.util.List;

/**
 * 菜单Service
 *
 * @author userqiao
 * @date 2020/06/07
 */
public interface MenuService {
    List<Menu> getMenusByUserId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();
}
