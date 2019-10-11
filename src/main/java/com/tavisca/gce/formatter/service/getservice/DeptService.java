package com.tavisca.gce.formatter.service.getservice;

import com.tavisca.gce.formatter.model.Department;
import com.tavisca.gce.formatter.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptRepository repository;

    public List<Department> getDepartments() {
        return repository.findAll();
    }
}
