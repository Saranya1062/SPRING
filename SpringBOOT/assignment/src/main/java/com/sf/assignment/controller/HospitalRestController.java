package com.sf.assignment.controller;

import com.sf.assignment.dao.HospitalDAO;
import com.sf.assignment.entity.Hospitals;
import com.sf.assignment.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HospitalRestController {

    private HospitalService hospitalService;

    private HospitalDAO hospitalDAO;

    @Autowired
    public HospitalRestController(HospitalService theHospitalService) {
        hospitalService=theHospitalService;
    }

    @GetMapping("/test")
    public List<Hospitals> findAll() {
        return hospitalService.findAll();
    }

    @GetMapping("/hos")
    public Hospitals getHospitalName(@PathVariable int hid) {

            return hospitalDAO.listName(hid);
    }

}

