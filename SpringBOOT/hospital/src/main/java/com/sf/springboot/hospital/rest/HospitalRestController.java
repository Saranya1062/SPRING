package com.sf.springboot.hospital.rest;

import com.sf.springboot.hospital.dao.HospitalDAO;
import com.sf.springboot.hospital.entity.Hospitals;
import com.sf.springboot.hospital.service.HospitalService;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalRestController {

//    @Value("${spring.demo.hid}")
//    private int data;

    private HospitalService hospitalService;

    @Autowired
    private HospitalDAO hospitalDAO;

    @Autowired
    private Hospitals hospitals;

    @Autowired
    public HospitalRestController(HospitalService theHospitalService) {
        hospitalService = theHospitalService;
    }

    @GetMapping("/test")
    public List<Hospitals> findAll() {
        return hospitalService.findAll();
    }

//    @Value("${spring.demo.hospital_ids_enabled}")
    @Value("#{'${spring.demo.hospital_ids_enabled}'.split(',')}")
    private int h_id;
    //private int h_id;

    @GetMapping("/name")
    public Hospitals getHospitalName() {

        return hospitalDAO.findName(h_id);
    }

}
