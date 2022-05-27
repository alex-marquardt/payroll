package com.training.payroll.repository;

import com.training.payroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, String>
{
}
