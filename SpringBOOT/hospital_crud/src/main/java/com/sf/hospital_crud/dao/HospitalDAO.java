package com.sf.hospital_crud.dao;

import com.sf.hospital_crud.entity.Hospitals;

import java.util.List;

public interface HospitalDAO {

    public List<Hospitals> findAll();

    public Hospitals findById(int theId);

    public Hospitals save(Hospitals theHospital);

    public void deleteById(int theId);
}
