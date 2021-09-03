package com.sf.backend.rest;

import com.sf.backend.dao.HospitalDAO;
import com.sf.backend.entity.Hospitals;
import com.sf.backend.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
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

    @Autowired
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


    @GetMapping("/hospital/id/{hosId}")
    public List<Hospitals> getHospitalFromId(@PathVariable int hosId) {
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