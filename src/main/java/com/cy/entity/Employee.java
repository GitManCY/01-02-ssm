package com.cy.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {

    private Long id;
    @NotNull(message="姓名不能为空")
    @Size(min=1,max=5,message="姓名的长度错误,请填写1-5位")
    private String name;
    @NotNull(message="性别不能为空！")
    private int sex;
    @NotNull(message="年龄不能为空！")
    private int age;
    @NotNull(message="git地址不能为空！")
    private String address;

    public Employee(Long id, String name, int sex, int age, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
