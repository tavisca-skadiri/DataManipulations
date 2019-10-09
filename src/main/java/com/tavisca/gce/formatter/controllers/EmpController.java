package com.tavisca.gce.formatter.controllers;

import com.tavisca.gce.formatter.model.Employee;
import com.tavisca.gce.formatter.model.Employees;
import com.tavisca.gce.formatter.service.EmpCsvFileService;
import com.tavisca.gce.formatter.service.EmpJsonFileService;
import com.tavisca.gce.formatter.service.EmpService;
import com.tavisca.gce.formatter.service.EmpXmlFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmpController {
    @Autowired
    private EmpJsonFileService empJsonFileService;
    @Autowired
    private EmpXmlFileService empXmlFileService;
    @Autowired
    private EmpService empService;
    @Autowired
    private EmpCsvFileService empCsvFileService;

    @GetMapping(path = "/")
    public ResponseEntity<Object> getEmployees() {
        List<Employee> employees = empService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(path = "/csv")
    public ResponseEntity<Object> getEmployeesInCSV() throws IOException {
        String csvContent = empCsvFileService.generateEmployeesCsvFile("employees.csv");
        if (csvContent.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(csvContent, HttpStatus.OK);
    }

    @GetMapping(path = "/json")
    public ResponseEntity<Object> generateEmployeesJsonFile() {
        String json = empJsonFileService.generateEmployeeJsonFile("employees.json");
        if (json.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping(path = "/xml")
    public ResponseEntity<Object> generateEmployeesXmlFile() {
        Employees employeeXml = empXmlFileService.generateEmployeesXmlFile("employees.xml");
        if (employeeXml.getEmployeeList().isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(employeeXml, HttpStatus.OK);
    }
}