package com.tavisca.gce.formatter.controllers;

import com.tavisca.gce.formatter.model.BasicDept;
import com.tavisca.gce.formatter.model.BasicEmp;
import com.tavisca.gce.formatter.model.DeptDetail;
import com.tavisca.gce.formatter.repository.BasicDeptRepository;
import com.tavisca.gce.formatter.repository.BasicEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeptDetailController {
    @Autowired
    private BasicDeptRepository basicDeptRepository;
    @Autowired
    private BasicEmpRepository basicEmpRepository;

    @GetMapping(path = "/deptemployees")
    public ResponseEntity<Object> getEmpsInEachDept() {
        List<DeptDetail> list = getDeptDetails();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/deptemployees/json")
    public ResponseEntity<Object> getEmpsInEachDeptJson() {
        List<DeptDetail> list = getDeptDetails();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(path = "/deptemployees/xml")
    public ResponseEntity<Object> getEmpsInEachDeptXml() {
        List<DeptDetail> list = getDeptDetails();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    private List<DeptDetail> getDeptDetails() {
        List<BasicEmp> employees = basicEmpRepository.findAll();
        List<BasicDept> departments = basicDeptRepository.findAll();
        List<DeptDetail> list = new ArrayList<>();
        departments.forEach((d -> {
            int deptId = d.getId();
            List<BasicEmp> allEmployee = employees.stream()
                    .filter(e -> e.getDept_id() == deptId)
                    .collect(Collectors.toList());
            list.add(new DeptDetail(allEmployee, d.getName()));
        }));
        return list;
    }
}