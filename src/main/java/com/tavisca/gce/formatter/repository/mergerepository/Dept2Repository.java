package com.tavisca.gce.formatter.repository.mergerepository;

import com.tavisca.gce.formatter.model.mergemodel.BasicDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dept2Repository extends JpaRepository<BasicDepartment, Integer> {
}
