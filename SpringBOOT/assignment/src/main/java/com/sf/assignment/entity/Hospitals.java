package com.sf.assignment.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="hospitals")
public class Hospitals {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="h_id")
    @Value("${spring.demo.hid}")
    private int hid;

    @Column(name="h_name")
    private String hname;

    @Column(name="location")
    private String location;

//    @JoinTable(
//            name = "hospitals_patients",
//            joinColumns = @JoinColumn(name = "H_id"),
//            inverseJoinColumns = @JoinColumn(name = "PIH_id")
//    )
//    private List<Patient> patients;

    public Hospitals() {

    }

    public Hospitals(int hid, String hname, String location) {
        this.hid=hid;
        this.hname = hname;
        this.location = location;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
