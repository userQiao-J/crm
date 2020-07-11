package com.userqiao.crm.service;

import com.github.pagehelper.PageInfo;
import com.userqiao.crm.model.OperLogModel;
import com.userqiao.crm.model.RespBean;

import java.util.List;

public interface OperationLogService {
    /**
     * 插入日志
     */
    void insert(OperLogModel operLogModel);

    PageInfo<OperLogModel> getOperLog(Integer currentPage, Integer pageSize);

    /**
     * 清除历史记录
     * @return
     */
    RespBean cleanLog();
}
