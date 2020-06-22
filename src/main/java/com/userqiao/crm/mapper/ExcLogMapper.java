package com.userqiao.crm.mapper;

import com.userqiao.crm.model.ExcLog;

public interface ExcLogMapper {
    int deleteByPrimaryKey(Integer excId);

    int insert(ExcLog record);

    int insertSelective(ExcLog record);

    ExcLog selectByPrimaryKey(Integer excId);

    int updateByPrimaryKeySelective(ExcLog record);

    int updateByPrimaryKeyWithBLOBs(ExcLog record);

    int updateByPrimaryKey(ExcLog record);
}