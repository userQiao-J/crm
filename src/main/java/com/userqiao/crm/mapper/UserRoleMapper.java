package com.userqiao.crm.mapper;

import com.userqiao.crm.model.UserRole;
/**
 * 用户角色 Mapper
 *
 * @author userqiao
 * @date 2020/06/05
 */
public interface UserRoleMapper {
    /**
     * 根据主键ID删除数据
     * @param id 用户角色ID
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增用户角色
     * @param record
     * @return
     */
    int insert(UserRole record);
    /**
     * 新增用户角色，但null值不会传入
     * @param record
     * @return
     */
    int insertSelective(UserRole record);
    /**
     * 根据id获取用户角色详情
     * @param id
     * @return
     */
    UserRole selectByPrimaryKey(Integer id);
    /**
     * 修改用户角色字段信息，同时如果为null，则不会修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserRole record);
    /**
     * 修改用户角色信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserRole record);
}