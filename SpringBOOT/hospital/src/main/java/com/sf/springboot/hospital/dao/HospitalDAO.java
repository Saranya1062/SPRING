package com.sf.springboot.hospital.dao;

import com.sf.springboot.hospital.entity.Hospitals;

import java.util.List;

public interface HospitalDAO {

    public List<Hospitals> findAll();

    public List<String> findName(String data);

    public List<String> findCon(String data);

    public Hospitals findContent(String data);

}
