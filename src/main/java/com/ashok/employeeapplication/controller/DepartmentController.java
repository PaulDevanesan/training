package com.ashok.employeeapplication.controller;

import com.ashok.employeeapplication.entity.Department;
import com.ashok.employeeapplication.entity.Employee;
import com.ashok.employeeapplication.service.DepartmentService;
import com.ashok.employeeapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restapi/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") Integer departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @PutMapping("/department")
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartmentById(@PathVariable("id") Integer departmentId){
        departmentService.deleteDepartmentById(departmentId);
    }

}
