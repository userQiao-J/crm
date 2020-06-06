package com.userqiao.crm.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.userqiao.crm.mapper.UserMapper;
import com.userqiao.crm.model.User;
import com.userqiao.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserService实现类
 *
 * @author userqiao
 * @date 2020/06/05
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (ObjectUtil.isNull(user)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        user.setPassword(null);
        return user;
    }
}
