package com.tavisca.gce.formatter.repository.mergerepository;

import com.tavisca.gce.formatter.model.mergemodel.BasicEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emp2Repository extends JpaRepository<BasicEmployee, Integer> {
}
