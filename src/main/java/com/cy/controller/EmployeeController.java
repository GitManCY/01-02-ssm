package com.cy.controller;

import com.cy.entity.Employee;
import com.cy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("/emp")
    public String addEmp(@Valid @RequestBody Employee employee, BindingResult bindingResult) throws Exception {
        String errorMessage = validate(bindingResult);
        if (errorMessage != null) {
            return errorMessage;
        }
        employeeService.save(employee);
        return "success";
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") long id) throws Exception {
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @PutMapping("/emp")
    public String updateEmp(@Valid @RequestBody Employee employee, BindingResult bindingResult) throws Exception {
        String errorMessage = validate(bindingResult);
        if (errorMessage != null) {
            return errorMessage;
        }
        Employee employeeById = employeeService.getEmployeeById(employee.getId());
        if (employeeById == null) {
            return "用户不存在";
//            throw new EmployeeException("用户不存在");
        }
        employeeService.update(employee);
        return "success";
    }

    @DeleteMapping("/emp/{id}")
    public String DeleteEmp(@PathVariable("id") int id) throws Exception {
        employeeService.delete(id);
        return "success";
    }

    private String validate(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = "校验失败";
            List<FieldError> list = bindingResult.getFieldErrors();
            for (FieldError error : list
            ) {
                errorMessage += error.getDefaultMessage() + ",";
            }
            return errorMessage;
        }
        return null;
    }

}
