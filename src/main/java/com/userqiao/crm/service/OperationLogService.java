package com.userqiao.crm.service;

import com.userqiao.crm.model.OperLogModel;

public interface OperationLogService {
    /**
     * 插入日志
     */
    void insert(OperLogModel operLogModel);
}
