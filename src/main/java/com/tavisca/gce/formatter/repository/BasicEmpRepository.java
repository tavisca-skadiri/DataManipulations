package com.tavisca.gce.formatter.repository;

import com.tavisca.gce.formatter.model.BasicEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicEmpRepository extends JpaRepository<BasicEmp, Integer> {
}
