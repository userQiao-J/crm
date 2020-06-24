package com.userqiao.crm.service.impl;

import com.userqiao.crm.mapper.UserRoleMapper;
import com.userqiao.crm.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public int getCountByRoleId(Integer roleId) {
        return userRoleMapper.getCountByRoleId(roleId);
    }
}
