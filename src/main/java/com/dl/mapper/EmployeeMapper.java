package com.dl.mapper;

import com.dl.bean.EmployeeBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by Administrator on 2020/5/18.
 */
public interface EmployeeMapper {
    @Results(id = "employeeMapper",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "lastName",property = "lastName"),
            @Result(column = "email",property = "email"),
            @Result(column = "gender",property = "gender"),
            @Result(column = "d_id",property = "dId"),
            @Result(column = "d_id",property = "departmentBean",one = @One(select = "com.dl.mapper.DepartmentMapper.findById",
                    fetchType= FetchType.EAGER))
    })
    @Select("select * from employee")
    List<EmployeeBean> findAll();//查询所有员工信息
    @Insert("insert into employee(lastName,email,birth,gender,d_id) values(#{lastName},#{email},#{birth},#{gender},#{dId})")
    void save(EmployeeBean employeeBean);
    @Select("select * from employee where id=#{id}")
    EmployeeBean findById(Integer id);
    @Update("update employee set lastName=#{lastName},email=#{email},birth=#{birth},gender=#{gender},d_id=#{dId} where id=#{id}")
    void updateEmployeeBean(EmployeeBean employeeBean);
    @Delete("delete from employee where id=#{id}")
    void deleteEmployeeBean(Integer id);
}
