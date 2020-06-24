package com.userqiao.crm.service;

public interface UserRoleService {

    /**
     * 根据角色id获取有角色信息的用户数量
     * @param roleId
     * @return
     */
    int getCountByRoleId(Integer roleId);
}
