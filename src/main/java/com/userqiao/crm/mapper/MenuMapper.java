package com.userqiao.crm.mapper;

import com.userqiao.crm.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单 Mapper
 *
 * @author userqiao
 * @date 2020/06/05
 */
public interface MenuMapper {
    /**
     * 根据主键ID删除数据
     * @param id 菜单ID
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增菜单
     * @param record
     * @return
     */
    int insert(Menu record);

    /**
     * 新增菜单，但null值不会传入
     * @param record
     * @return
     */
    int insertSelective(Menu record);

    /**
     * 根据id获取菜单详情
     * @param id
     * @return
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     * 修改菜单字段信息，同时如果为null，则不会修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * 修改菜单信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Menu record);

    /**
     * 根据当前用户，获取到用户所对应的菜单
     * @param userId
     * @return
     */
    List<Menu> getMenusByUserId(@Param("userId") Integer userId);

    /**
     * 获取所有的菜单角色
     * @return
     */
    List<Menu> getMenusWithRole();
}