package com.userqiao.crm.service.impl;

import com.userqiao.crm.mapper.RoleMapper;
import com.userqiao.crm.model.Role;
import com.userqiao.crm.service.RoleService;
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
    @Override
    public List<Role> getAllRole() {
        //@TODO 后期将其保存到Redis缓存里,不要每次都查询数据库
        return roleMapper.getAllRole();
    }
}
