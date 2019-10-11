package com.tavisca.gce.formatter.model.mergemodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "employees")
public class BasicEmployee implements Serializable {
    @Id
    private int id;
    private int empid;
    private String name;
    private int salary;
    private int dept_id;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "BasicEmployee{" +
                "id=" + id +
                ", empid=" + empid +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", dept_id=" + dept_id +
                '}';
    }
}