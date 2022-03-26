package com.ashok.employeeapplication.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(){
        super();
    }

    public ProjectNotFoundException(String str) {
        super(str);
    }
}
