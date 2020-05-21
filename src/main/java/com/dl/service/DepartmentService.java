package com.dl.service;

import com.dl.bean.DepartmentBean;

import java.util.List;

/**
 * Created by Administrator on 2020/5/18.
 */
public interface DepartmentService {
    List<DepartmentBean> findAllDepartment();
}
