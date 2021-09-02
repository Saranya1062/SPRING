package com.sf.hospital_crud.service;

import com.sf.hospital_crud.entity.Hospitals;

import java.util.List;

public interface HospitalService {

    public List<Hospitals> findAll();

    public Hospitals findById(int theId);

    public void save(Hospitals theHospital);

    public void deleteById(int theId);
}
