package com.userqiao.crm.controller.system;

import com.github.pagehelper.PageInfo;
import com.userqiao.crm.aop.OperLog;
import com.userqiao.crm.controller.BaseController;
import com.userqiao.crm.model.OperLogModel;
import com.userqiao.crm.model.PageRequest;
import com.userqiao.crm.model.RespBean;
import com.userqiao.crm.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/log")
public class LogController extends BaseController {
    private final static String OPER_MODUL="操作日志管理";
    @Autowired
    OperationLogService operationLogService;
    @PostMapping("/getOperLog")
    @OperLog(operModul = OPER_MODUL,operType = LOGCONST_GET,operDesc = "分页查询操作日志列表")
    public PageInfo<OperLogModel> getOperLog(@RequestBody PageRequest pageRequest){
        return operationLogService.getOperLog(pageRequest.getPageNum(),pageRequest.getPageSize());
    }

    /**
     * 此接口在正式项目当中不适合使用，即便要用也要仔细判断代码的可行性
     * @return
     */
    @DeleteMapping("/")
    @OperLog(operModul = OPER_MODUL,operType = LOGCONST_DELETE,operDesc = "清楚日志记录")
    public RespBean cleanLog(){
        return operationLogService.cleanLog();
    }
}
