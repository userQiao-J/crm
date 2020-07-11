package com.userqiao.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.userqiao.crm.mapper.OperLogModelMapper;
import com.userqiao.crm.model.OperLogModel;
import com.userqiao.crm.model.RespBean;
import com.userqiao.crm.model.User;
import com.userqiao.crm.service.OperationLogService;
import com.userqiao.crm.utils.UserUtils;
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
        PageHelper.startPage(currentPage, pageSize);
        User user = UserUtils.getUser();
        PageInfo<OperLogModel> operLogModelPageInfo = null;
        if (user.getId() == 3) {
            //超级管理员 可以查看所有日志
            operLogModelPageInfo = new PageInfo<>(operLogModelMapper.selectAll());
        } else {
            // 其他用户只可以查看自己的日志
            operLogModelPageInfo = new PageInfo<>(operLogModelMapper.selectLogByUser(user.getId()));
        }

        return operLogModelPageInfo;
    }

    @Override
    public RespBean cleanLog() {
        if ( operLogModelMapper.cleanLog()>0){
            return RespBean.ok("清除日志成功");
        }else{
            return RespBean.error("清除日志失败");
        }

    }
}
