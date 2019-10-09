package com.tavisca.gce.formatter.repository;

import com.tavisca.gce.formatter.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
