package com.userqiao.crm.mapper;

import com.userqiao.crm.model.User;
/**
 * 用户 Mapper
 *
 * @author userqiao
 * @date 2020/06/05
 */
public interface UserMapper {
    /**
     * 根据主键ID删除数据
     * @param id 用户ID
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增用户
     * @param record
     * @return
     */
    int insert(User record);
    /**
     * 新增用户，但null值不会传入
     * @param record
     * @return
     */
    int insertSelective(User record);
    /**
     * 根据id获取用户详情
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);
    /**
     * 修改用户字段信息，同时如果为null，则不会修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);
    /**
     * 修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
}