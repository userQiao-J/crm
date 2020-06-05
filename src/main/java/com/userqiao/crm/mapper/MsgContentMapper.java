package com.userqiao.crm.mapper;

import com.userqiao.crm.model.MsgContent;
/**
 * 消息内容 Mapper
 *
 * @author userqiao
 * @date 2020/06/05
 */
public interface MsgContentMapper {
    /**
     * 根据主键ID删除数据
     * @param id 消息内容ID
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增消息内容
     * @param record
     * @return
     */
    int insert(MsgContent record);
    /**
     * 新增消息内容，但null值不会传入
     * @param record
     * @return
     */
    int insertSelective(MsgContent record);
    /**
     * 根据id获取消息内容详情
     * @param id
     * @return
     */
    MsgContent selectByPrimaryKey(Integer id);

    /**
     * 修改消息内容字段信息，同时如果为null，则不会修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MsgContent record);
    /**
     * 修改消息内容信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(MsgContent record);
}