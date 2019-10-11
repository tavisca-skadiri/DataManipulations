package com.tavisca.gce.formatter.service.formatservice;

import com.tavisca.gce.formatter.model.formatmodel.Employees;
import com.tavisca.gce.formatter.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

@Service
public class EmpXmlService {
    @Autowired
    private EmpRepository repo;

    public Employees generateEmployeesXmlFile(String filename) {
        File file = new File("formats/" + filename);
        Employees employees = new Employees();
        employees.setEmployeeList(new ArrayList<>());
        employees.getEmployeeList().addAll(repo.findAll());
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(employees, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return employees;
    }
}