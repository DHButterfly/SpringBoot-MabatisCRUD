package com.dl.controller;

import com.dl.bean.DepartmentBean;
import com.dl.bean.EmployeeBean;
import com.dl.mapper.DepartmentMapper;
import com.dl.mapper.EmployeeMapper;
import com.dl.service.impl.DepartmentServiceImpl;
import com.dl.service.impl.EmployeeServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    //查询所有员工返回列表页面  ,分页功能待完善
    /*
    @GetMapping("/emps")
    public String list(Model model){
        //查询所有员工，添加到视图中
        List<EmployeeBean> employees=employeeService.findAllEmployee();
        model.addAttribute("emps",employees);
        return "emp/list";
    }*/

    /**
     *
     * @param model  视图解析器
     * @param pageNum  第几页
     * @param pageSize 一页显示记录数
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model,@RequestParam(name="pageNum",defaultValue = "1",required = false)Integer pageNum,
                       @RequestParam(name = "pageSize",defaultValue = "5",required = false) Integer pageSize){
        //引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pageNum, pageSize);
        //startPage后紧跟的这个查询就是分页查询
        //查询所有员工，添加到视图中
        List<EmployeeBean> employees=employeeService.findAllEmployee();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<EmployeeBean>(employees, 5);
        model.addAttribute("emps",pageInfo);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        //总的记录数
        model.addAttribute("record", pageInfo.getTotal());
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
