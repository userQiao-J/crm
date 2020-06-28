package com.userqiao.crm.service.impl;

import com.userqiao.crm.mapper.DepartmentMapper;
import com.userqiao.crm.model.Department;
import com.userqiao.crm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAllDepartmentByParentId() {
        return departmentMapper.getAllDepartmentByParentId(-1);
    }
}
