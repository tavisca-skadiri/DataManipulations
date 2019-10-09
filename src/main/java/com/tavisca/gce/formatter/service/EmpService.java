package com.tavisca.gce.formatter.service;

import com.tavisca.gce.formatter.model.Department;
import com.tavisca.gce.formatter.model.Employee;
import com.tavisca.gce.formatter.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepository repo;

    public List<Employee> addEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Saqlain");
        employee.setDesignation("Trainee");
        employee.setEmpid(547);
        employee.setSalary(10000);
        employee.setHobbies("cricket,football");
        Department department = new Department();
        department.setId(1);
        department.setName("ff");
        employee.setDept(department);
        repo.save(employee);
        return repo.findAll();
    }
    public List<Employee> getEmployees() {
        return repo.findAll();
    }
}