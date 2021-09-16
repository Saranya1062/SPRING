package com.sf.hospital_crud.rest;

import com.sf.hospital_crud.dao.HospitalDAO;
import com.sf.hospital_crud.entity.Hospitals;
import com.sf.hospital_crud.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalRestController {

    @Autowired
    RestTemplate restTemplate;

    private HospitalService hospitalService;

    @Autowired
    private HospitalDAO hospitalDAO;

    @Autowired
    public HospitalRestController(HospitalService theHospitalService) {
        hospitalService = theHospitalService;
    }

    @GetMapping("/hospital")
    public List<Hospitals> findAll() {
        return hospitalService.findAll();
    }

    @GetMapping("/hospitals/{hospitalId}")
    public Hospitals findById(@PathVariable int hospitalId) {
        Hospitals theHospital = hospitalService.findById(hospitalId);

        if (theHospital == null) {
            throw new RuntimeException("HospitalId id not found - " + hospitalId);
        }
        return theHospital;
    }

    @PostMapping("/hospital")
    public Hospitals addHospital(@RequestBody Hospitals theHospital) {
//        try {
            theHospital.setHid(0);
            hospitalService.save(theHospital);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return theHospital;
    }

    @GetMapping("/hospital/id/{hosId}")
    public List<Hospitals> getHospitalFromRest(@PathVariable int hosId) {
        String url = "http://localhost:8080/api/hospital";

        ResponseEntity <List<Hospitals>> response =restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Hospitals>>() {});

        List<Hospitals> data = response.getBody();
        int hid=0;
        List<Hospitals> results=new ArrayList<>();
        for(Hospitals hos:data){
            hid=hos.getHid();
            if(hid==hosId){
                results.add(hos);
            }
        }
        return results;
    }

    @GetMapping("/hospital/name/{hosName}")
    public List<Hospitals> getHospitalFromName(@PathVariable String hosName) {
        String url = "http://localhost:8080/api/hospital";

        ResponseEntity <List<Hospitals>> response =restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Hospitals>>() {});

        List<Hospitals> data = response.getBody();
        List<Hospitals> results=new ArrayList<>();
        for(Hospitals hos:data){
            if((hos.getHname()).equals(hosName)){
                results.add(hos);
            }
        }
        return results;
    }
}