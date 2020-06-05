package com.userqiao.crm.mapper;

import com.userqiao.crm.model.Role;
/**
 * 角色 Mapper
 *
 * @author userqiao
 * @date 2020/06/05
 */
public interface RoleMapper {
    /**
     * 根据主键ID删除数据
     * @param id 角色ID
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增角色
     * @param record
     * @return
     */
    int insert(Role record);
    /**
     * 新增角色，但null值不会传入
     * @param record
     * @return
     */
    int insertSelective(Role record);
    /**
     * 根据id获取角色详情
     * @param id
     * @return
     */
    Role selectByPrimaryKey(Integer id);
    /**
     * 修改角色字段信息，同时如果为null，则不会修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Role record);
    /**
     * 修改角色信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Role record);
}