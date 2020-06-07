package com.userqiao.crm.utils;

import com.userqiao.crm.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author userqiao
 * @Title: Utils.java
 * @Package com.userqiao.crm.utils
 * @Description: 用户相关工具类
 * @date 2020/6/718:51
 */
public class UserUtils {
    /**
     * 获取当前登录用户信息
     * @return 当前登录用户信息
     */
    public static User getUser(){
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
