package com.tavisca.gce.formatter.repository;

import com.tavisca.gce.formatter.model.BasicDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicDeptRepository extends JpaRepository<BasicDept, Integer> {
}
