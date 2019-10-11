package com.tavisca.gce.formatter.service.getservice;

import com.tavisca.gce.formatter.model.Employee;
import com.tavisca.gce.formatter.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepository repo;

    public List<Employee> getEmployees() {
        return repo.findAll();
    }
}