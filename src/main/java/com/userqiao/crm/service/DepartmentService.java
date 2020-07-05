package com.userqiao.crm.service;

import com.userqiao.crm.model.Department;
import com.userqiao.crm.model.RespBean;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartmentByParentId();

    /**
     * 添加部门
     * @param department
     * @return
     */
    boolean addDepartment(Department department);

    /**
     * 根据ID删除部门信息
     * @param id
     * @return
     */
    RespBean deleteDepartment(Integer id);
}
