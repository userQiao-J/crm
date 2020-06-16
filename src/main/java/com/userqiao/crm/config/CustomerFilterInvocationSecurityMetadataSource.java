package com.userqiao.crm.config;

import com.userqiao.crm.model.Menu;
import com.userqiao.crm.model.Role;
import com.userqiao.crm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author userqiao
 * @Title: MyFilter.java
 * @Package com.userqiao.crm.config
 * @Description: Filter配置类 提供权限访问 根据用户传来的请求地址，分析出请求需要的角色
 * @date 2020/6/14 18:30
 */
@Component
public class CustomerFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;

    AntPathMatcher pathMatcher = new AntPathMatcher();

    /** 根据用户的地址，分析出是否存在角色
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 获取当前请求的URL地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> menusWithRole = menuService.getMenusWithRole();
        for (Menu menu : menusWithRole) {
            if (pathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
