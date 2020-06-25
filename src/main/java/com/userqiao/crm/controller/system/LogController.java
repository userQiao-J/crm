package com.userqiao.crm.controller.system;

import com.github.pagehelper.PageInfo;
import com.userqiao.crm.mapper.PageResult;
import com.userqiao.crm.model.OperLogModel;
import com.userqiao.crm.model.RespBean;
import com.userqiao.crm.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/log")
public class LogController {
    @Autowired
    OperationLogService operationLogService;
    @GetMapping("/getOperLog")
    public PageInfo<OperLogModel> getOperLog(){
        return operationLogService.getOperLog(0,5);
    }
}
