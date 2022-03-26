package com.ashok.employeeapplication.service;

import com.ashok.employeeapplication.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartment(Integer departmentId);

    List<Department> getDepartments();

    Department updateDepartment(Department department);

    void deleteDepartmentById(Integer departmentId);
}
