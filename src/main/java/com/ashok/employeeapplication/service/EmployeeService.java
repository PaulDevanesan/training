package com.ashok.employeeapplication.service;

import com.ashok.employeeapplication.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Integer employeeId);

    List<Employee> getEmployees();

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(Integer employeeId);
}
