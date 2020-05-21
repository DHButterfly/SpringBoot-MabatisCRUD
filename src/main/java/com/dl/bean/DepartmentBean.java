package com.dl.bean;

/**
 * Created by Administrator on 2020/5/19.
 */
public class DepartmentBean {
    private Integer id;
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "DepartmentBean{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
