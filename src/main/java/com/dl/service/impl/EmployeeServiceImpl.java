package com.dl.service.impl;

import com.dl.bean.EmployeeBean;
import com.dl.mapper.DepartmentMapper;
import com.dl.mapper.EmployeeMapper;
import com.dl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/5/18.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeBean> findAllEmployee() {
        return employeeMapper.findAll();
    }

    @Override
    public void save(EmployeeBean employeeBean) {
        employeeMapper.save(employeeBean);
    }

    @Override
    public EmployeeBean findEmployeeById(Integer id) {
        return employeeMapper.findById(id);
    }

    @Override
    public void update(EmployeeBean employeeBean) {
        employeeMapper.updateEmployeeBean(employeeBean);
    }

    @Override
    public void delete(Integer id) {
        employeeMapper.deleteEmployeeBean(id);
    }

}
