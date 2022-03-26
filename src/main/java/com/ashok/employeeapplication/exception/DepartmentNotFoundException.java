package com.ashok.employeeapplication.exception;


public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(String str) {
        super(str);
    }
}
