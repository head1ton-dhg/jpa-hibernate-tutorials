package com.youwiz.primarykey.repository;

import com.youwiz.primarykey.model.Employee;
import com.youwiz.primarykey.model.EmployeeIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeIdentity> {

    List<Employee> findByEmployeeIdentityCompanyId(String companyId);
}
