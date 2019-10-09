package com.tavisca.gce.formatter.controllers;

import com.tavisca.gce.formatter.model.Department;
import com.tavisca.gce.formatter.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptRepository deptRepository;

    @GetMapping(path = "/departments")
    public ResponseEntity<Object> getDepartmemt() {
        List<Department> departments = deptRepository.findAll();
        if (departments.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}