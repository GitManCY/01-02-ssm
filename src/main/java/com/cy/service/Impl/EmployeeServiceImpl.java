package com.cy.service.Impl;

import com.cy.dao.EmployeeDao;
import com.cy.entity.Employee;
import com.cy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    
    //增加一个员工
    @Transactional
    @Override
    public void save(Employee employee) throws Exception {
        employeeDao.save(employee);
    }

    //修改员工信息
    @Transactional
    @Override
    public void update(Employee employee)throws Exception{
         employeeDao.update(employee);
    }

    //通过id查询员工
    @Override
    public Employee getEmployeeById(long id){
        return employeeDao.getEmployeeById(id);
    }

    //删除员工通过id
    @Override
    public void delete(int id)throws Exception{
       employeeDao.delete(id);
    }
}
