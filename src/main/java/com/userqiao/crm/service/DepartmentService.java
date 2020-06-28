package com.userqiao.crm.service;

import com.userqiao.crm.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartmentByParentId();
}
