package com.example.course_system.ErrorHandling;

public class DepartmentExceptionHandler extends Exception{


    public DepartmentExceptionHandler() {
        super();
    }

    public DepartmentExceptionHandler(String message) {
        super(message);
    }

    public DepartmentExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentExceptionHandler(Throwable cause) {
        super(cause);
    }

    protected DepartmentExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
