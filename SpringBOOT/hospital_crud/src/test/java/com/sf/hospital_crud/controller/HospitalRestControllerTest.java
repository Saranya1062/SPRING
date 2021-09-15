package com.sf.hospital_crud.controller;

import com.sf.hospital_crud.entity.Hospitals;
import com.sf.hospital_crud.rest.HospitalRestController;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalRestControllerTest {

    @Autowired
    private HospitalRestController hospitalRestController;

    @Test
    public void findAll() {
        List<Hospitals> hos=null;
        hos=hospitalRestController.findAll();
        assertEquals(5,hos.size());
        assertNotNull(hos);
        assertFalse(hos.isEmpty());

    }

    @Test
    public void throwsExceptionForNameIsNull() {
        Hospitals hospitals= new Hospitals(4,null,"Chennai");
        assertThrows(RuntimeException.class , () -> {
            hospitalRestController.addHospital(hospitals);
        });
    }

    @Test
    public void findById() {
        Integer hid=1;
        Hospitals hospitals=hospitalRestController.findById(hid);
        assertEquals(1,hospitals.getHid());
        assertNotNull(hospitals.getHid());
 //     assertThrows(NumberFormatException.class , () -> Integer.parseInt("aaa"));
    }

    @Test
    public void save() {
        Hospitals hospitals=new Hospitals(3,"yy","aaa");
        Hospitals hos=hospitalRestController.addHospital(hospitals);
        assertEquals(hos,hospitals);
    }
}
