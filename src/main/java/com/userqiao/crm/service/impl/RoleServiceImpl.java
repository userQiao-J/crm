package com.userqiao.crm.service.impl;

import com.userqiao.crm.mapper.RoleMapper;
import com.userqiao.crm.model.RespBean;
import com.userqiao.crm.model.Role;
import com.userqiao.crm.service.RoleMenuService;
import com.userqiao.crm.service.RoleService;
import com.userqiao.crm.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author userqiao
 * @Title: RoleServiceImpl
 * @Package com.userqiao.crm.service.impl
 * @Description:
 * @date 2020/6/21 15:47
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoleMenuService roleMenuService;
    @Autowired
    UserRoleService userRoleService;
    @Override
    public List<Role> getAllRole() {
        //@TODO 后期将其保存到Redis缓存里,不要每次都查询数据库
        return roleMapper.getAllRole();
    }

    @Override
    public RespBean deleteRole(String roleId) {
        String msg = "删除成功";
        int countByRoleId = userRoleService.getCountByRoleId(Integer.parseInt(roleId));
        if (countByRoleId>0){
            return RespBean.error("该角色绑定了用户,无法删除");
        }
        roleMenuService.deleteRoleMenuByRoleId(roleId);
        roleMapper.deleteByPrimaryKey(Integer.parseInt(roleId));
        return RespBean.ok(msg);
    }

    @Override
    public Integer addRole(Role role) {
        int result = roleMapper.insertSelective(role);
        return result;
    }
}
