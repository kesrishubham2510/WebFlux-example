package com.myreflectionthoughts.webfluxdemo;


import lombok.ToString;

@ToString
public class Employee {
    private String firstName;
    private String role;
   
    public Employee(String firstName, String role) {
        this.firstName = firstName;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getRole() {
        return role;
    }
}
