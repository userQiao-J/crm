package com.userqiao.crm.service;

import com.userqiao.crm.model.RespBean;
import com.userqiao.crm.model.Role;

import java.util.List;

/**
 * @author userqiao
 * @Title: RoleService
 * @Package com.userqiao.crm.service
 * @Description: 角色Service
 * @date 2020/6/21 14:33
 */
public interface RoleService {
    /**
     * 获取所有的角色信息
     * @return
     */
    List<Role> getAllRole();

    /**
     * 根据用户ID删除对应的角色信息
     * @param roleId
     */
    RespBean deleteRole(String roleId);
}
