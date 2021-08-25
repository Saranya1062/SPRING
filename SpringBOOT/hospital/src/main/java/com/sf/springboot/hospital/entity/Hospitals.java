package com.sf.springboot.hospital.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Entity
@Table(name="hospitals")
@ConfigurationProperties(prefix="spring.demo")
@Configuration
public class Hospitals {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "h_id")
    public int hid;

    @Column(name = "h_name")
    private String hname;

    @Column(name = "location")
    private String location;

    public Hospitals() {

    }

    public Hospitals(int hid, String hname, String location) {
        this.hid = hid;
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
