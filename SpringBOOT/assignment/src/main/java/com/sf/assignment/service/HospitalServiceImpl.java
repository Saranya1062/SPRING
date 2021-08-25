package com.sf.assignment.service;

import com.sf.assignment.dao.HospitalDAO;
import com.sf.assignment.entity.Hospitals;

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
