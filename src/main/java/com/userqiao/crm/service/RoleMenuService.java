package com.userqiao.crm.service;

import io.swagger.models.auth.In;

/**
 * @author userqiao
 * @Title: RoleMenuService
 * @Package com.userqiao.crm.service
 * @Description: 角色菜单关联Service
 * @date 2020/6/24
 */
public interface RoleMenuService {
    /**
     * 根据角色ID删除与菜单之间的关联关系
     * @param roleId
     */
    void deleteRoleMenuByRoleId(String roleId);

    Integer insertRecorId(Integer rid, Integer[] mids);

    /**
     * 根据菜单ID获取存在记录的条数
     * @param mid
     * @return
     */
    Integer getCountByMid(Integer mid);
}
