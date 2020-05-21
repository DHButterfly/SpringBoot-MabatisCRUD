package com.dl.service;

import com.dl.bean.EmployeeBean;

import java.util.List;

/**
 * Created by Administrator on 2020/5/18.
 */

public interface EmployeeService {
    List<EmployeeBean> findAllEmployee();
    void save(EmployeeBean employeeBean);
    EmployeeBean findEmployeeById(Integer id);
    void update(EmployeeBean employeeBean);
    void delete(Integer id);
}
