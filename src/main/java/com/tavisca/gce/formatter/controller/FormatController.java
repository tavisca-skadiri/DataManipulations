package com.tavisca.gce.formatter.controller;

import com.tavisca.gce.formatter.model.formatmodel.Employees;
import com.tavisca.gce.formatter.service.formatservice.EmpCsvService;
import com.tavisca.gce.formatter.service.formatservice.EmpJsonService;
import com.tavisca.gce.formatter.service.formatservice.EmpXmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/employees")
public class FormatController {
    @Autowired
    private EmpJsonService empJsonService;
    @Autowired
    private EmpXmlService empXmlService;
    @Autowired
    private EmpCsvService empCsvService;

    @GetMapping(path = "/csv")
    public ResponseEntity<Object> getEmployeesInCSV() throws IOException {
        String csvContent = empCsvService.generateEmployeesCsvFile("employees.csv");
        if (csvContent.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(csvContent, HttpStatus.OK);
    }

    @GetMapping(path = "/json")
    public ResponseEntity<Object> generateEmployeesJsonFile() {
        String json = empJsonService.generateEmployeeJsonFile("employees.json");
        if (json.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping(path = "/xml")
    public ResponseEntity<Object> generateEmployeesXmlFile() {
        Employees employeeXml = empXmlService.generateEmployeesXmlFile("employees.xml");
        if (employeeXml.getEmployeeList().isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(employeeXml, HttpStatus.OK);
    }
}