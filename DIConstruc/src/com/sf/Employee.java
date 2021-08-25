package com.sf;

public class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void show(){
        System.out.println(id+" "+name);
    }
}
