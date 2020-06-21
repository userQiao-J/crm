package com.userqiao.crm.service.impl;

import com.userqiao.crm.mapper.MenuMapper;
import com.userqiao.crm.model.Menu;
import com.userqiao.crm.model.User;
import com.userqiao.crm.service.MenuService;
import com.userqiao.crm.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author userqiao
 * @Title: MenuServiceImpl
 * @Package com.userqiao.crm.service.impl
 * @Description: 菜单Service实现类
 * @date 2020/6/718:47
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<Menu> getMenusByUserId() {
        return menuMapper.getMenusByUserId(UserUtils.getUser().getId());
    }

    @Override
    public List<Menu> getMenusWithRole() {
        // 建议 查询出来后保存到Redis当中去，不要每次都去查询数据库。严重影响效率
        return menuMapper.getMenusWithRole();
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
