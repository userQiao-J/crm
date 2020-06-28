package com.userqiao.crm.controller.system.basic;

import com.userqiao.crm.model.Department;
import com.userqiao.crm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartmentByParentId();
    }
}
