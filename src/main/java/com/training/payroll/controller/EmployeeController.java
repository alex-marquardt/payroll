package com.training.payroll.controller;

import com.training.payroll.exception.EmployeeNotFoundException;
import com.training.payroll.model.Employee;
import com.training.payroll.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Aggregate item
    @GetMapping("/employees")
    public List<Employee> all() {
        return repository.findAll();
    }

    // Single item
    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
