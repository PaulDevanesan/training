package com.ashok.employeeapplication.service.Impl;

import com.ashok.employeeapplication.entity.Department;
import com.ashok.employeeapplication.exception.DepartmentNotFoundException;
import com.ashok.employeeapplication.repository.DepartmentRepository;
import com.ashok.employeeapplication.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(Integer departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(department.isPresent()) {
            return department.get();
        }
        else{
            throw new DepartmentNotFoundException("Department not found for this id");
        }
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department) {
        Department existingDepartment = getDepartment(department.getDepartmentId());
        existingDepartment.setDepartmentName(department.getDepartmentName() !=null ?department.getDepartmentName(): existingDepartment.getDepartmentName());
        return departmentRepository.save(existingDepartment);
    }

    @Override
    public void deleteDepartmentById(Integer departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
