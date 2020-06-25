package com.userqiao.crm.service.impl;

import com.userqiao.crm.mapper.MenuRoleMapper;
import com.userqiao.crm.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    MenuRoleMapper menuRoleMapper;
    @Override
    public void deleteRoleMenuByRoleId(String roleId) {
        menuRoleMapper.deleteByRoleId(Integer.parseInt(roleId));
    }

    @Override
    public Integer insertRecorId(Integer rid, Integer[] mids) {
        return menuRoleMapper.insertRecorId(rid,mids);
    }
}
