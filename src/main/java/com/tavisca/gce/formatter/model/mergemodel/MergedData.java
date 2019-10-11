package com.tavisca.gce.formatter.model.mergemodel;

import java.util.List;

public class MergedData {
    private List<BasicEmployee> employees;
    private String deptName;

    public MergedData(List<BasicEmployee> employees, String deptName) {
        this.employees = employees;
        this.deptName = deptName;
    }

    public List<BasicEmployee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<BasicEmployee> employees) {
        this.employees = employees;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
