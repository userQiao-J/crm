package com.userqiao.crm.controller.system.basic;

import com.userqiao.crm.aop.OperLog;
import com.userqiao.crm.controller.BaseController;
import com.userqiao.crm.model.Department;
import com.userqiao.crm.model.RespBean;
import com.userqiao.crm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author userqiao
 * @Title: DepartmentController
 * @Package com.userqiao.crm.controller.system.basic
 * @Description: 部门控制器
 * @date 2020/6/26
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController extends BaseController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    @OperLog(operModul = "基础信息设置-部门管理", operType = LOGCONST_GET, operDesc = "查询出部门管理的列表")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartmentByParentId();
    }

    /**
     * 添加部门
     *
     * @param department
     * @return
     */
    @PostMapping("/")
    @OperLog(operModul = "基础信息设置-部门管理", operType = LOGCONST_ADD, operDesc = "添加部门")
    public RespBean addDepartment(@RequestBody Department department) {
        if (departmentService.addDepartment(department)) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }
}
