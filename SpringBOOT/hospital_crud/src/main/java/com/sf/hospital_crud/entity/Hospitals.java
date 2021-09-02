package com.sf.hospital_crud.entity;

import javax.persistence.*;

@Entity
@Table(name="hospitals")
public class Hospitals {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "h_id")
    public int hid;

    @Column(name = "h_name")
    private String hname;

    @Column(name = "location")
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_id")
    private Patients patients;

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

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Hospitals{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", location='" + location + '\'' +
                ", patients=" + patients +
                '}';
    }
}