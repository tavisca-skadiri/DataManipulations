package com.tavisca.gce.formatter.model;

import java.util.List;

public class DeptDetail {
    private List<BasicEmp> employees;
    private String deptName;

    public DeptDetail(List<BasicEmp> employees, String deptName) {
        this.employees = employees;
        this.deptName = deptName;
    }

    public List<BasicEmp> getEmployees() {
        return employees;
    }

    public void setEmployees(List<BasicEmp> employees) {
        this.employees = employees;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
