package com.sf.hospital_crud.service;

import com.sf.hospital_crud.dao.HospitalDAO;
import com.sf.hospital_crud.entity.Hospitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService{

    private HospitalDAO hospitalDAO;

    @Autowired
    public HospitalServiceImpl(HospitalDAO theHospitalDAO) {
        hospitalDAO=theHospitalDAO;
    }

    @Override
    @Transactional
    public List<Hospitals> findAll() {
        return hospitalDAO.findAll();
    }

    @Override
    @Transactional
    public Hospitals findById(int theId) {
        return hospitalDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Hospitals theHospital) {
        hospitalDAO.save(theHospital);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {

    }
}
