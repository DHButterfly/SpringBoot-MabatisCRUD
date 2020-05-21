package com.dl.service.impl;

import com.dl.bean.DepartmentBean;
import com.dl.mapper.DepartmentMapper;
import com.dl.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/5/18.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<DepartmentBean> findAllDepartment() {
        return departmentMapper.findAllDepartment();
    }
}
