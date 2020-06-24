package com.userqiao.crm.service.impl;

import com.userqiao.crm.mapper.ExcLogMapper;
import com.userqiao.crm.model.ExcLog;
import com.userqiao.crm.service.ExceptionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {
    @Autowired
    ExcLogMapper excLogMapper;
    @Override
    public void insert(ExcLog excepLog) {
        excLogMapper.insert(excepLog);
    }
}
