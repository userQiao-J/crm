package com.userqiao.crm.service;

import com.userqiao.crm.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartmentByParentId();

    /**
     * 添加部门
     * @param department
     * @return
     */
    boolean addDepartment(Department department);
}
