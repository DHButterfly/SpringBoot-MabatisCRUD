package com.dl.mapper;

import com.dl.bean.DepartmentBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2020/5/18.
 */
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    DepartmentBean findById(Integer id);
    @Select("select * from department")
    List<DepartmentBean> findAllDepartment();
}
