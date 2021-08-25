package com.sf.springboot.hospital.service;

import com.sf.springboot.hospital.dao.HospitalDAO;
import com.sf.springboot.hospital.entity.Hospitals;
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


}
