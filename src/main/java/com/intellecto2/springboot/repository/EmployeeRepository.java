package com.intellecto2.springboot.repository;

import com.intellecto2.springboot.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}