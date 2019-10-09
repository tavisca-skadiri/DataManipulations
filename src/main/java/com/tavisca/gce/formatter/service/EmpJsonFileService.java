package com.tavisca.gce.formatter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tavisca.gce.formatter.model.Employee;
import com.tavisca.gce.formatter.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class EmpJsonFileService {
    @Autowired
    private EmpRepository repo;

    public String generateEmployeeJsonFile(String filename) {
        List<Employee> employeeList = repo.findAll();
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(employeeList);
            FileOutputStream out = new FileOutputStream("formats/" + filename);
            out.write(json.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
