package com.userqiao.crm.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.userqiao.crm.mapper.DepartmentMapper;
import com.userqiao.crm.model.Department;
import com.userqiao.crm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartmentByParentId() {
        return departmentMapper.getAllDepartmentByParentId(-1);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addDepartment(Department department) {
        department.setParent(false);
        department.setEnabled(true);
        try {
            // 1.拿到父级部门id
            Integer parentId = department.getParentId();
            if (ObjectUtil.isNull(parentId)){
                return false;
            }
            //2.设置其父级部门为父级部门
            departmentMapper.setIsParentById(true,parentId);
            Department parrentDepartment = departmentMapper.selectByPrimaryKey(parentId);
            department.setDepPath(parrentDepartment.getDepPath());
            //3.添加部门
            departmentMapper.insertSelective(department);
            department.setDepPath(department.getDepPath()+"."+department.getId());
            departmentMapper.updateByPrimaryKeySelective(department);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
