package com.employee;


import com.employee.modelEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<modelEmployee, Long> {
}

