package com.dl.controller;

import com.dl.bean.DepartmentBean;
import com.dl.bean.EmployeeBean;
import com.dl.mapper.DepartmentMapper;
import com.dl.mapper.EmployeeMapper;
import com.dl.service.impl.DepartmentServiceImpl;
import com.dl.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2020/5/10.
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private DepartmentServiceImpl departmentService;
    /*
    *修改为Mybatis方式，初步考虑两种方案，使用三张表，employee和department+中间表||employee中添加字段did和department
     */
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        //查询所有员工，添加到视图中
        List<EmployeeBean> employees=employeeService.findAllEmployee();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    //点击员工添加来到员工添加页面 get请求
    @GetMapping("/emp")
    public String toEmployeeAddPage(Model model){
        //查询所有部门添加到视图中
        List<DepartmentBean> departments=departmentService.findAllDepartment();
        model.addAttribute("depts",departments);
        return "emp/edit";
    }
    //添加员工
    @PostMapping("/emp")
    public String addEmployee(EmployeeBean employeeBean){
        System.out.println("添加的员工信息"+employeeBean);
        //保存员工信息
        employeeService.save(employeeBean);
        return "redirect:/emps";
    }
    //来到员工修改页面,使用@PathVariable接收请求参数id,查出当前员工进行页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        EmployeeBean employeeBean= employeeService.findEmployeeById(id);
        model.addAttribute("emp",employeeBean);
        //页面要显示所有的部门列表
        List<DepartmentBean> departments=departmentService.findAllDepartment();
        model.addAttribute("depts",departments);
        return "emp/edit";
    }
    //修改员工信息
    @PutMapping("/emp")
    public String updateEmployee(EmployeeBean employeeBean){
        System.out.println(employeeBean);
        employeeService.update(employeeBean);
        return "redirect:/emps";
    }
    //删除员工信息
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.POST)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.delete(id);
        return "redirect:/emps";
    }
}
