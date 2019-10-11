package com.tavisca.gce.formatter.controller;

import com.tavisca.gce.formatter.model.Department;
import com.tavisca.gce.formatter.model.Employee;
import com.tavisca.gce.formatter.service.getservice.DeptService;
import com.tavisca.gce.formatter.service.getservice.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetRequestController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private EmpService empService;

    @GetMapping(path = "/departments")
    public ResponseEntity<Object> getDepartments() {
        List<Department> departments = deptService.getDepartments();
        if (departments.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping(path = "/employees")
    public ResponseEntity<Object> getEmployees() {
        List<Employee> employees = empService.getEmployees();
        if (employees.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}