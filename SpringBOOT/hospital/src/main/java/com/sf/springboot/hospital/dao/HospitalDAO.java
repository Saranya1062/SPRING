package com.sf.springboot.hospital.dao;

import com.sf.springboot.hospital.entity.Hospitals;

import java.util.List;

public interface HospitalDAO {

    public List<Hospitals> findAll();

    public Hospitals findName(int h_id);

    public Hospitals findById(int hid);
}
