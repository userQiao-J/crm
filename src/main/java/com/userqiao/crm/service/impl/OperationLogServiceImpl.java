package com.userqiao.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.userqiao.crm.mapper.OperLogModelMapper;
import com.userqiao.crm.model.OperLogModel;
import com.userqiao.crm.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    OperLogModelMapper operLogModelMapper;
    @Override
    public void insert(OperLogModel operLogModel) {
        operLogModelMapper.insert(operLogModel);
    }

    @Override
    public PageInfo<OperLogModel> getOperLog(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<OperLogModel> operLogModelPageInfo = new PageInfo<>(operLogModelMapper.selectAll());
        return operLogModelPageInfo;
    }
}
