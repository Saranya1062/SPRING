package com.sf.springboot.cruddemo.entity;  //1

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id              // id --> primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")   //clm annotation is to map these fields to a given db column name
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Employee() {
        //required by hibernate
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;             //id is automatically generated
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee: id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email;
    }
}
