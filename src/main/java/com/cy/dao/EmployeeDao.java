package com.cy.dao;

import com.cy.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeDao {


    @Update("UPDATE employee SET name = #{name}, age= #{age},sex= #{sex},address = #{address} WHERE id = #{id}")
    public void update(Employee employee);

    @Insert("INSERT INTO employee (name,sex,age,address) VALUES (#{name},#{sex},#{age},#{address})")
    void save(Employee employee);


    @Select("SELECT id,name,sex,age,address FROM employee WHERE id = #{id}")
    Employee getEmployeeById(long id);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void delete(int id);
}
