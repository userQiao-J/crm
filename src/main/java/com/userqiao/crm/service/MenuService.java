package com.userqiao.crm.service;

import com.userqiao.crm.model.Menu;
import com.userqiao.crm.model.RespBean;

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

    /**
     * 获取所有菜单
     */
    List<Menu> getAllMenus();

    /**
     * 根据角色ID获取到与菜单之间的关联关系
     * @param rid
     * @return
     */
    RespBean getMidsByRid(Integer rid);

    boolean updateMenuRole(Integer rid, Integer[] mids);

    Menu getMenuById(Integer mid);

    /**
     * 添加菜单
     * @return
     */
    RespBean addMenu(Menu menu);
}
