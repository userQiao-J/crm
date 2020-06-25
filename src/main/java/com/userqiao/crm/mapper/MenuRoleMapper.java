package com.userqiao.crm.mapper;

import com.userqiao.crm.model.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * 菜单角色 Mapper
 *
 * @author userqiao
 * @date 2020/06/05
 */
public interface MenuRoleMapper {
    /**
     * 根据主键ID删除数据
     * @param id 菜单角色ID
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增菜单角色
     * @param record
     * @return
     */
    int insert(MenuRole record);
    /**
     * 新增菜单角色，但null值不会传入
     * @param record
     * @return
     */
    int insertSelective(MenuRole record);
    /**
     * 根据id获取菜单角色详情
     * @param id
     * @return
     */
    MenuRole selectByPrimaryKey(Integer id);
    /**
     * 修改菜单角色字段信息，同时如果为null，则不会修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MenuRole record);
    /**
     * 修改菜单角色信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(MenuRole record);

    int deleteByRoleId(Integer roleId);

    Integer insertRecorId(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}