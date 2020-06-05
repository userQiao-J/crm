package com.userqiao.crm.mapper;

import com.userqiao.crm.model.OpLog;
/**
 * 操作日志 Mapper
 *
 * @author userqiao
 * @date 2020/06/05
 */
public interface OpLogMapper {
    /**
     * 根据主键ID删除数据
     * @param id 操作日志ID
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增操作日志
     * @param record
     * @return
     */
    int insert(OpLog record);
    /**
     * 新增操作日志，但null值不会传入
     * @param record
     * @return
     */
    int insertSelective(OpLog record);
    /**
     * 根据id获取操作日志详情
     * @param id
     * @return
     */
    OpLog selectByPrimaryKey(Integer id);
    /**
     * 修改操作日志字段信息，同时如果为null，则不会修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OpLog record);
    /**
     * 修改操作日志信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(OpLog record);
}