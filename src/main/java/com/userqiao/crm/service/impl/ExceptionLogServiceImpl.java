package com.userqiao.crm.service.impl;

import com.userqiao.crm.model.ExcLog;
import com.userqiao.crm.service.ExceptionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {
    @Autowired
    ExceptionLogService exceptionLogService;
    @Override
    public void insert(ExcLog excepLog) {
        exceptionLogService.insert(excepLog);
    }
}
