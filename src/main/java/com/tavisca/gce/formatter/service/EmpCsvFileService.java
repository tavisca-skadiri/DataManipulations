package com.tavisca.gce.formatter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.tavisca.gce.formatter.model.Employee;
import com.tavisca.gce.formatter.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpCsvFileService {
    @Autowired
    private EmpRepository repo;

    public String generateEmployeesCsvFile(String filename) throws IOException {
        Path path = Paths.get("formats/" + filename);
        List<Employee> employees = new ArrayList<>(repo.findAll());
        CsvMapper mapper = new CsvMapper();
        CsvSchema columns = mapper.schemaFor(Employee.class)
                .withHeader()
                .withColumnSeparator(',');
        String csvContent = "";
        try {
            csvContent = mapper.writer(columns).writeValueAsString(employees);
            FileOutputStream out = new FileOutputStream("formats/" + filename);
            out.write(csvContent.getBytes());
            out.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new String(Files.readAllBytes(path));
    }
}