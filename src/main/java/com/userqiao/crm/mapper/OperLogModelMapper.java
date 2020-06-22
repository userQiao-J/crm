package com.userqiao.crm.mapper;

import com.userqiao.crm.model.OperLogModel;

public interface OperLogModelMapper {
    int deleteByPrimaryKey(Integer operId);

    int insert(OperLogModel record);

    int insertSelective(OperLogModel record);

    OperLogModel selectByPrimaryKey(Integer operId);

    int updateByPrimaryKeySelective(OperLogModel record);

    int updateByPrimaryKeyWithBLOBs(OperLogModel record);

    int updateByPrimaryKey(OperLogModel record);
}