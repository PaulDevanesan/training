package com.ashok.employeeapplication.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super();
    }

    public EmployeeNotFoundException(String str) {
        super(str);
    }

}
