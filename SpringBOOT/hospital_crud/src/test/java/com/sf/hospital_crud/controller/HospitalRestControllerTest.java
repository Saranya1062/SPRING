package com.sf.hospital_crud.controller;

import com.sf.hospital_crud.entity.Hospitals;
import com.sf.hospital_crud.rest.HospitalRestController;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
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
        List<Hospitals> hos = hospitalRestController.findAll();
        assertNotNull(hos);
        assertEquals(6,hos.size());
        assertFalse(hos.isEmpty());
    }

    @Test
    public void throwsExceptionForNameIsNull() {
        Hospitals hospitals = new Hospitals(4,null,"Chennai");
  //    Hospitals hos=null;
  //    assertThrows(NullPointerException.class, () -> hospitalRestController.addHospital(hos));
        assertThrows(DataIntegrityViolationException.class ,() -> {
            hospitalRestController.addHospital(hospitals);
        });
    }

    @Test
    public void findById() {
        int hid = 1;
        Hospitals hospitals = hospitalRestController.findById(hid);
        assertNotNull(hospitals);
        assertEquals(1, hospitals.getHid());
    }

    @Test
    public void save() {
        Hospitals hospitals = new Hospitals(3,"yy","aaa");
        Hospitals hos = hospitalRestController.addHospital(hospitals);
        assertEquals(hos,hospitals);
    }
}
