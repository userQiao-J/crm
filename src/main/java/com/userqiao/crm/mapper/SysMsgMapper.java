package com.userqiao.crm.mapper;

import com.userqiao.crm.model.SysMsg;

/**
 * 系统消息 Mapper
 *
 * @author userqiao
 * @date 2020/06/05
 */
public interface SysMsgMapper {
    /**
     * 根据主键ID删除数据
     * @param id 系统消息ID
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增系统消息
     * @param record
     * @return
     */
    int insert(SysMsg record);
    /**
     * 新增系统消息，但null值不会传入
     * @param record
     * @return
     */
    int insertSelective(SysMsg record);
    /**
     * 根据id获取系统消息详情
     * @param id
     * @return
     */
    SysMsg selectByPrimaryKey(Integer id);
    /**
     * 修改系统消息字段信息，同时如果为null，则不会修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysMsg record);
    /**
     * 修改系统消息信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysMsg record);
}