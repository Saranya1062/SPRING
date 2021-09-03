package com.sf.backend.entity;

import javax.persistence.*;

@Entity
@Table(name="patients")
public class Patients {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="p_id")
    private int pid;

    @Column(name="p_name")
    private String pname;

    @Column(name="age")
    private int age;

    public Patients() {

    }

    public Patients(int pid, String pname, int age) {
        this.pid = pid;
        this.pname = pname;
        this.age = age;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", age=" + age +
                '}';
    }
}