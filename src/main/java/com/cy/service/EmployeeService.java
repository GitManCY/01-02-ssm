package com.cy.service;

import com.cy.entity.Employee;

public interface EmployeeService {


    //增加一个员工
    public void save(Employee employee) throws Exception;


    //修改员工信息
    public void update(Employee employee) throws Exception;


    //通过id查询员工
    public Employee getEmployeeById(long id);

    //删除员工通过id
    public void delete (int id) throws Exception;


}
