package com.sf.springboot.hospital.rest;

import com.sf.springboot.hospital.dao.HospitalDAO;
import com.sf.springboot.hospital.entity.Hospitals;
import com.sf.springboot.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalRestController {

    private HospitalService hospitalService;

    @Autowired
    private HospitalDAO hospitalDAO;

    @Autowired
    public HospitalRestController(HospitalService theHospitalService) {
        hospitalService = theHospitalService;
    }

    @GetMapping("/test")
    public List<Hospitals> findAll() {
        return hospitalService.findAll();
    }

//    @Value("#{'${spring.demo.hospital_ids_enabled}'.split(',')}")
    @Value("${spring.demo.hospital_ids_enabled}")
    private String h_id;


    @GetMapping("/name")
    public Hospitals getHospitalName() {

//        for(int i=0;i<=h_id.length;i++) {
//            return hospitalDAO.findContent(h_id);
//        }

      // return h_id;
       return hospitalDAO.findContent(h_id);

    }

}
