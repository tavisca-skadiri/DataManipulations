package com.tavisca.gce.formatter.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public Department() {
    }

    public Department(String name, Employee... employees) {
        this.name = name;
        this.employees = Stream.of(employees).collect(Collectors.toSet());
        this.employees.forEach(e -> e.setDept(this));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BasicDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
