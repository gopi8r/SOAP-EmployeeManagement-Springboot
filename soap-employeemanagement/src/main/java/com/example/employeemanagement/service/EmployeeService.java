package com.example.employeemanagement.service;

import com.example.employees.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public Employee getEmployeeById(String id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("John Doe");
        employee.setPosition("Software Developer");
        return employee;
    }
}

