package com.tavisca.gce.formatter.repository;

import com.tavisca.gce.formatter.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Department, Integer> {
}
