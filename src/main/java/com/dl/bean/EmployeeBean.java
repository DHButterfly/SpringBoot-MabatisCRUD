package com.dl.bean;


import java.util.Date;

/**
 * Created by Administrator on 2020/5/19.
 */
public class EmployeeBean {
    private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
    private DepartmentBean departmentBean;
    private Date birth;
    private Integer dId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }

    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", departmentBean=" + departmentBean +
                ", birth=" + birth +
                ", dId=" + dId +
                '}';
    }
}
