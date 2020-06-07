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
}
