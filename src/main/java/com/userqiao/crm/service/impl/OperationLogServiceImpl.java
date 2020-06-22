package com.userqiao.crm.service.impl;

import com.userqiao.crm.mapper.OperLogModelMapper;
import com.userqiao.crm.model.OperLogModel;
import com.userqiao.crm.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    OperLogModelMapper operLogModelMapper;
    @Override
    public void insert(OperLogModel operLogModel) {
        operLogModelMapper.insert(operLogModel);
    }
}
