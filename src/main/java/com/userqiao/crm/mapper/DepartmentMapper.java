package com.userqiao.crm.mapper;

import com.userqiao.crm.model.Department;
/**
 * 部门 Mapper
 *
 * @author userqiao
 * @date 2020/06/05
 */
public interface DepartmentMapper {
    /**
     * 根据主键ID删除数据
     * @param id 部门ID
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增部门
     * @param record
     * @return
     */
    int insert(Department record);
    /**
     * 新增部门，但null值不会传入
     * @param record
     * @return
     */
    int insertSelective(Department record);
    /**
     * 根据id获取部门详情
     * @param id
     * @return
     */
    Department selectByPrimaryKey(Integer id);
    /**
     * 修改部门字段信息，同时如果为null，则不会修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Department record);
    /**
     * 修改部门信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Department record);
}