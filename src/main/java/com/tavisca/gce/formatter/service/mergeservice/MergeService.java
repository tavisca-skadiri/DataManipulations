package com.tavisca.gce.formatter.service.mergeservice;

import com.tavisca.gce.formatter.model.mergemodel.BasicDepartment;
import com.tavisca.gce.formatter.model.mergemodel.BasicEmployee;
import com.tavisca.gce.formatter.model.mergemodel.MergedData;
import com.tavisca.gce.formatter.repository.mergerepository.Dept2Repository;
import com.tavisca.gce.formatter.repository.mergerepository.Emp2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MergeService {
    @Autowired
    private Emp2Repository empRepo;
    @Autowired
    private Dept2Repository deptRepo;

    public List<MergedData> getMergedData() {
        List<BasicEmployee> employees = empRepo.findAll();
        List<BasicDepartment> departments = deptRepo.findAll();
        return mergeLists(employees, departments);
    }

    private List<MergedData> mergeLists(List<BasicEmployee> employees, List<BasicDepartment> departments) {
        List<MergedData> list = new ArrayList<>();
        departments.forEach((d -> {
            List<BasicEmployee> allEmployee = employees.stream()
                    .filter(e -> e.getDept_id() == d.getId())
                    .collect(Collectors.toList());
            list.add(new MergedData(allEmployee, d.getName()));
        }));
        return list;
    }
}