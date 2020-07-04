package com.cy.entity;

public class EmployeeException extends Exception{
    //异常信息
    public String message;

    public EmployeeException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
