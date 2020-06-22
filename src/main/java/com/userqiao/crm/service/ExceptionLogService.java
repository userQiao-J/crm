package com.userqiao.crm.service;

import com.userqiao.crm.model.ExcLog;

public interface ExceptionLogService {
    /**
     * 插入异常信息
     * @param excepLog
     */
    void insert(ExcLog excepLog);
}
