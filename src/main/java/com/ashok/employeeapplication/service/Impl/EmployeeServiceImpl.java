package com.ashok.employeeapplication.service.Impl;

import com.ashok.employeeapplication.entity.Employee;
import com.ashok.employeeapplication.exception.EmployeeNotFoundException;
import com.ashok.employeeapplication.repository.EmployeeRepository;
import com.ashok.employeeapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()) {
            return employee.get();
        }
        else{
            throw new EmployeeNotFoundException("Employee not found for this id");
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = getEmployee(employee.getEmployeeId());
        existingEmployee.setEmployeeName(employee.getEmployeeName() !=null ? employee.getEmployeeName() : existingEmployee.getEmployeeName());
        existingEmployee.setEmployeeEmail(employee.getEmployeeEmail() !=null ? employee.getEmployeeEmail() : existingEmployee.getEmployeeEmail());
        existingEmployee.setDepartmentId(employee.getDepartmentId() !=null ? employee.getDepartmentId() : existingEmployee.getDepartmentId());
        existingEmployee.setProjectId(employee.getProjectId() !=null ? employee.getProjectId()  : existingEmployee.getProjectId());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
